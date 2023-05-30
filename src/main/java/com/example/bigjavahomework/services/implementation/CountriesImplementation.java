package com.example.bigjavahomework.services.implementation;

import com.example.bigjavahomework.entityes.Countries;
import com.example.bigjavahomework.repositoryes.CountriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bigjavahomework.services.CountriesService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountriesImplementation implements CountriesService {
    private final CountriesRepository countriesRepository;

    @Override
    public List<Countries> allCountries() {
        return countriesRepository.findAll();
    }

    @Override
    public Countries save(Countries country) {
        return countriesRepository.save(country);
    }

    @Override
    public Countries update(Countries country) {
        Countries existingCountry = countriesRepository.findById(country.getCode()).orElse(null);
        if (existingCountry != null) {
            existingCountry.setName(country.getName());
            existingCountry.setLocation(country.getLocation());
            existingCountry.setAllowed(country.getAllowed());
            return countriesRepository.save(existingCountry);
        }
        return countriesRepository.save(country);
    }

    @Override
    public void deleteById(String code) {
        countriesRepository.deleteById(code);
    }

    @Override
    public Countries findById(String code) {
        return countriesRepository.findById(code).orElse(null);
    }
}