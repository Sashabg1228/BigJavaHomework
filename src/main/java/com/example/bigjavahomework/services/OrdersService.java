package com.example.bigjavahomework.services;

import com.example.bigjavahomework.resources.OrdersResource;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<OrdersResource> getAll();
    Optional<OrdersResource> getById(Integer id);
    OrdersResource create(OrdersResource orderResource);
    OrdersResource update(OrdersResource orderResource, Integer id);
    void deleteById(Integer id);
}