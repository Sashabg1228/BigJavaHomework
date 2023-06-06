package com.example.bigjavahomework.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.OrdersResource;
import com.example.bigjavahomework.services.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ordersService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<OrdersResource> ordersResource = ordersService.getById(id);

        if (ordersResource.isPresent()) {
            return ResponseEntity.ok(ordersResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find order with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody OrdersResource ordersResource) {
        OrdersResource createdOrder = ordersService.create(ordersResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/orders/{id}").buildAndExpand(createdOrder.getId()).toUri()
        ).body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody OrdersResource ordersResource, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(ordersService.update(ordersResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        ordersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}