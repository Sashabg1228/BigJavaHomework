package com.example.bigjavahomework.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.ProductsResource;
import com.example.bigjavahomework.services.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<ProductsResource> productsResource = productsService.getById(id);

        if (productsResource.isPresent()) {
            return ResponseEntity.ok(productsResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find product with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductsResource productsResource) {
        ProductsResource createdProduct = productsService.create(productsResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/products/{id}").buildAndExpand(createdProduct.getId()).toUri()
        ).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ProductsResource productsResource, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(productsService.update(productsResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        productsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}