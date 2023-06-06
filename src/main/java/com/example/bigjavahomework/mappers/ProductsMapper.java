package com.example.bigjavahomework.mappers;

import com.example.bigjavahomework.resources.ProductsResource;
import com.example.bigjavahomework.entityes.Products;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductsMapper {
    ProductsMapper PRODUCTS_MAPPER = Mappers.getMapper(ProductsMapper.class);

    Products fromProductsResource(ProductsResource productsResource);

    ProductsResource toProductsResource(Products products);

    List<ProductsResource> toProductsResources(List<Products> products);
}