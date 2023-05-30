package com.example.bigjavahomework.services.implementation;

import com.example.bigjavahomework.entityes.Customers;
import com.example.bigjavahomework.repositoryes.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bigjavahomework.services.CustomersService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersImplementation implements CustomersService {
    private final CustomersRepository customersRepository;

    @Override
    public List<Customers> allCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Customers save(Customers customer) {
        return customersRepository.save(customer);
    }

    @Override
    public Customers update(Customers customer) {
        Customers existingCustomer = customersRepository.findById(customer.getId()).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setUsername(customer.getUsername());
            existingCustomer.setPassword(customer.getPassword());
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            return customersRepository.save(existingCustomer);
        }
        return customersRepository.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
        customersRepository.deleteById(id);
    }

    @Override
    public Customers findById(Integer id) {
        return customersRepository.findById(id).orElse(null);
    }
}