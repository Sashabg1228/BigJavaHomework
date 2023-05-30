package com.example.bigjavahomework.services.implementation;

import com.example.bigjavahomework.entityes.Products;
import com.example.bigjavahomework.repositoryes.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bigjavahomework.services.ProductsService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsImplementation implements ProductsService {
    private final ProductsRepository productsRepository;

    @Override
    public List<Products> allProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products save(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Products update(Products product) {
        Products existingProduct = productsRepository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setWeight(product.getWeight());
            existingProduct.setInfo(product.getInfo());
            return productsRepository.save(existingProduct);
        }
        return productsRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Products findById(Integer id) {
        return productsRepository.findById(id).orElse(null);
    }
}
