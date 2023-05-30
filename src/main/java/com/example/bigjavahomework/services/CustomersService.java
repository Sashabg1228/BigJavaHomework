package com.example.bigjavahomework.services;

import com.example.bigjavahomework.entityes.Customers;
import java.util.List;

public interface CustomersService {
    List<Customers> allCustomers();
    Customers findById(Integer id);
    Customers save(Customers customer);
    Customers update(Customers customer);
    void deleteById(Integer id);
}