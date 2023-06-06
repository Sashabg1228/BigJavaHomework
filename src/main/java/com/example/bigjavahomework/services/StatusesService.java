package com.example.bigjavahomework.services;

import com.example.bigjavahomework.resources.StatusesResource;

import java.util.List;
import java.util.Optional;

public interface StatusesService {
    List<StatusesResource> getAll();
    Optional<StatusesResource> getByCode(String code);
    StatusesResource create(StatusesResource statusResource);
    StatusesResource update(StatusesResource statusResource, String code);
    void deleteByCode(String code);
}