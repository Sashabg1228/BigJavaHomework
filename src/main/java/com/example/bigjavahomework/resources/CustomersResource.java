package com.example.bigjavahomework.resources;

import com.example.bigjavahomework.entityes.Addresses;
import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class CustomersResource {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Addresses address;
}