package com.example.bigjavahomework.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.CustomersResource;
import com.example.bigjavahomework.entityes.Customers;
import com.example.bigjavahomework.repositoryes.CustomersRepository;
import com.example.bigjavahomework.services.CustomersService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bigjavahomework.mappers.CustomersMapper.CUSTOMERS_MAPPER;

@Service
@RequiredArgsConstructor
public class CustomersImplementation implements CustomersService {
    private final CustomersRepository customersRepository;

    @Override
    public List<CustomersResource> getAll() {
        return CUSTOMERS_MAPPER.toCustomersResources(customersRepository.findAll());
    }

    @Override
    public Optional<CustomersResource> getById(Integer id) {
        return customersRepository.findById(id).map(CUSTOMERS_MAPPER::toCustomersResource);
    }

    @Override
    public CustomersResource create(CustomersResource customersResource) {
        try {
            Customers customers = customersRepository.save(CUSTOMERS_MAPPER.fromCustomersResource(customersResource));
            customersResource.setId(customers.getId());
            return customersResource;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Customer with id " + customersResource.getId() + " already exists.");
        }
    }

    @Override
    public CustomersResource update(CustomersResource customersResource, Integer id) {
        try {
            Customers customers = customersRepository.getReferenceById(id);

            customers.setUsername(customersResource.getUsername());
            customers.setPassword(customersResource.getPassword());
            customers.setName(customersResource.getName());
            customers.setAddress(customersResource.getAddress());

            return CUSTOMERS_MAPPER.toCustomersResource(customersRepository.save(customers));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Unable to find customer with id " + id + ".");
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (customersRepository.existsById(id)) {
            customersRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find customer with id " + id + ".");
        }
    }
}