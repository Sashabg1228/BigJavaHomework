package com.example.bigjavahomework.services;

import com.example.bigjavahomework.entityes.Orders;
import java.util.List;

public interface OrdersService {
    List<Orders> allOrders();
    Orders findById(Integer id);
    Orders save(Orders order);
    Orders update(Orders order);
    void deleteById(Integer id);
}