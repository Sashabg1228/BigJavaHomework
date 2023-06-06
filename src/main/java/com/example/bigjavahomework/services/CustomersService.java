package com.example.bigjavahomework.services;

import com.example.bigjavahomework.resources.CustomersResource;

import java.util.List;
import java.util.Optional;

public interface CustomersService {
    List<CustomersResource> getAll();
    Optional<CustomersResource> getById(Integer id);
    CustomersResource create(CustomersResource customerResource);
    CustomersResource update(CustomersResource customerResource, Integer id);
    void deleteById(Integer id);
}