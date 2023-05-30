package com.example.bigjavahomework.resources;

import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class ProductsResource {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private Double weight;
    private String info;
}