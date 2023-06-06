package com.example.bigjavahomework.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.CountriesResource;
import com.example.bigjavahomework.services.CountriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountriesController {
    private final CountriesService countriesService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(countriesService.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getByCode(@PathVariable("code") String code) {
        Optional<CountriesResource> countriesResource = countriesService.getByCode(code);

        if (countriesResource.isPresent()) {
            return ResponseEntity.ok(countriesResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find country with code " + code + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CountriesResource countriesResource) {
        CountriesResource createdCountries = countriesService.create(countriesResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/countries/{code}").buildAndExpand(createdCountries.getCode()).toUri()
        ).body(createdCountries);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@Valid @RequestBody CountriesResource countriesResource, @PathVariable("code") String code) {
        return ResponseEntity.ok(countriesService.update(countriesResource, code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") String code) {
        countriesService.deleteById(code);
        return ResponseEntity.noContent().build();
    }
}