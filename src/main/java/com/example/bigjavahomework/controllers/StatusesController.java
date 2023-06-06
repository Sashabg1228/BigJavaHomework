package com.example.bigjavahomework.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.StatusesResource;
import com.example.bigjavahomework.services.StatusesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/statuses")
@RequiredArgsConstructor
public class StatusesController {
    private final StatusesService statusesService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(statusesService.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getByCode(@PathVariable("code") String code) {
        Optional<StatusesResource> statusesResource = statusesService.getByCode(code);

        if (statusesResource.isPresent()) {
            return ResponseEntity.ok(statusesResource.get());
        } else {
            throw new EntityNotFoundException("Unable to find status with code " + code + ".");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody StatusesResource statusesResource) {
        StatusesResource createdStatus = statusesService.create(statusesResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/statuses/{code}").buildAndExpand(createdStatus.getCode()).toUri()
        ).body(createdStatus);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@Valid @RequestBody StatusesResource statusesResource, @PathVariable("code") String code) {
        return ResponseEntity.ok(statusesService.update(statusesResource, code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") String code) {
        statusesService.deleteByCode(code);
        return ResponseEntity.noContent().build();
    }
}