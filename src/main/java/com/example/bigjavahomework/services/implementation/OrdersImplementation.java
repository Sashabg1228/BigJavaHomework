package com.example.bigjavahomework.services.implementation;

import com.example.bigjavahomework.entityes.Orders;
import com.example.bigjavahomework.repositoryes.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bigjavahomework.services.OrdersService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersImplementation implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> allOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders save(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public Orders update(Orders order) {
        Orders existingOrder = ordersRepository.findById(order.getId()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCustomer(order.getCustomer());
            existingOrder.setAddress(order.getAddress());
            existingOrder.setPhone(order.getPhone());
            existingOrder.setCreationDate(order.getCreationDate());
            existingOrder.setStatus(order.getStatus());
            return ordersRepository.save(existingOrder);
        }
        return ordersRepository.save(order);
    }

    @Override
    public void deleteById(Integer id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Orders findById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }
}
