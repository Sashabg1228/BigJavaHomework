package com.example.bigjavahomework.services;

import com.example.bigjavahomework.resources.ProductsResource;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductsResource> getAll();
    Optional<ProductsResource> getById(Integer id);
    ProductsResource create(ProductsResource productResource);
    ProductsResource update(ProductsResource productResource, Integer id);
    void deleteById(Integer id);
}