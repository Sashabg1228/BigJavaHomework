package com.example.bigjavahomework.services;

import com.example.bigjavahomework.entityes.Products;
import java.util.List;

public interface ProductsService {
    List<Products> allProducts();
    Products findById(Integer id);
    Products save(Products product);
    Products update(Products product);
    void deleteById(Integer id);
}