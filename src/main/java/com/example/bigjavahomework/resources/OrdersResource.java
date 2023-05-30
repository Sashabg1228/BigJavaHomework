package com.example.bigjavahomework.resources;

import com.example.bigjavahomework.entityes.Customers;
import com.example.bigjavahomework.entityes.Addresses;
import com.example.bigjavahomework.entityes.Statuses;
import jakarta.annotation.Resource;
import java.util.Date;
import lombok.Data;

@Resource
@Data
public class OrdersResource {
    private Integer id;
    private Customers customer;
    private Addresses address;
    private String phone;
    private Date creationDate;
    private Statuses status;
}