package com.example.bigjavahomework.services;

import com.example.bigjavahomework.resources.CountriesResource;

import java.util.List;
import java.util.Optional;

public interface CountriesService {
    List<CountriesResource> getAll();
    Optional<CountriesResource> getByCode(String code);
    CountriesResource create(CountriesResource country);
    CountriesResource update(CountriesResource country, String code);
    void deleteById(String code);
}