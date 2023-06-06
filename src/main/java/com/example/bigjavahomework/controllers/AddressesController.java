package com.example.bigjavahomework.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.AddressesResource;
import com.example.bigjavahomework.services.AddressesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressesController {
    private final AddressesService addressesService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(addressesService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<AddressesResource> addressesResource = addressesService.getById(id);

        if (addressesResource.isPresent()) {
            return ResponseEntity.ok(addressesResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find address with id " + id + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AddressesResource addressesResource) {
        AddressesResource createdAddresses = addressesService.create(addressesResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/addresses/{id}").buildAndExpand(createdAddresses.getId()).toUri()
        ).body(createdAddresses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody AddressesResource addressesResource, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(addressesService.update(addressesResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        addressesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}