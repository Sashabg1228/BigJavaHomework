package com.example.bigjavahomework.services;

import com.example.bigjavahomework.resources.AddressesResource;
import java.util.List;
import java.util.Optional;

public interface AddressesService {
    List<AddressesResource> getAll();
    Optional<AddressesResource> getById(Integer id);
    AddressesResource create(AddressesResource addressesResource);
    AddressesResource update(AddressesResource addressesResource, Integer id);
    void deleteById(Integer id);
}