package com.example.bigjavahomework.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.CustomersResource;
import com.example.bigjavahomework.services.CustomersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersService customersService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(customersService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<CustomersResource> customersResource = customersService.getById(id);

        if (customersResource.isPresent()) {
            return ResponseEntity.ok(customersResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find customer with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CustomersResource customersResource) {
        CustomersResource createdCustomer = customersService.create(customersResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/customers/{id}").buildAndExpand(createdCustomer.getId()).toUri()
        ).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CustomersResource customersResource, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(customersService.update(customersResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        customersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}