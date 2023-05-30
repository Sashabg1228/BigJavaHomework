package com.example.bigjavahomework.services;

import com.example.bigjavahomework.entityes.Countries;
import java.util.List;

public interface CountriesService {
    List<Countries> allCountries();
    Countries findById(String code);
    Countries save(Countries country);
    Countries update(Countries country);
    void deleteById(String code);
}