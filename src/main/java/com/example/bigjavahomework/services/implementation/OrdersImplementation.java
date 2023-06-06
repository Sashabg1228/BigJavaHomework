package com.example.bigjavahomework.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.OrdersResource;
import com.example.bigjavahomework.entityes.Orders;
import com.example.bigjavahomework.repositoryes.OrdersRepository;
import com.example.bigjavahomework.services.OrdersService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bigjavahomework.mappers.OrdersMapper.ORDERS_MAPPER;

@Service
@RequiredArgsConstructor
public class OrdersImplementation implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public List<OrdersResource> getAll() {
        return ORDERS_MAPPER.toOrdersResources(ordersRepository.findAll());
    }

    @Override
    public Optional<OrdersResource> getById(Integer id) {
        return ordersRepository.findById(id).map(ORDERS_MAPPER::toOrdersResource);
    }

    @Override
    public OrdersResource create(OrdersResource ordersResource) {
        try {
            Orders orders = ordersRepository.save(ORDERS_MAPPER.fromOrdersResource(ordersResource));
            ordersResource.setId(orders.getId());
            return ordersResource;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Order with id " + ordersResource.getId() + " already exists.");
        }
    }

    @Override
    public OrdersResource update(OrdersResource ordersResource, Integer id) {
        try {
            Orders orders = ordersRepository.getReferenceById(id);

            orders.setCustomer(ordersResource.getCustomer());
            orders.setAddress(ordersResource.getAddress());
            orders.setPhone(ordersResource.getPhone());
            orders.setCreationDate(ordersResource.getCreationDate());
            orders.setStatus(ordersResource.getStatus());

            return ORDERS_MAPPER.toOrdersResource(ordersRepository.save(orders));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Unable to find order with id " + id + ".");
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (ordersRepository.existsById(id)) {
            ordersRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find order with id " + id + ".");
        }
    }
}