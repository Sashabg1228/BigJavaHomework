package com.example.bigjavahomework.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.CountriesResource;
import com.example.bigjavahomework.entityes.Countries;
import com.example.bigjavahomework.repositoryes.CountriesRepository;
import com.example.bigjavahomework.services.CountriesService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bigjavahomework.mappers.CountriesMapper.COUNTRIES_MAPPER;

@Service
@RequiredArgsConstructor
public class CountriesImplementation implements CountriesService {
    private final CountriesRepository countriesRepository;

    @Override
    public List<CountriesResource> getAll() {
        return COUNTRIES_MAPPER.toCountriesResources(countriesRepository.findAll());
    }

    @Override
    public Optional<CountriesResource> getByCode(String code) {
        return countriesRepository.findById(code).map(COUNTRIES_MAPPER::toCountriesResource);
    }

    @Override
    public CountriesResource create(CountriesResource countriesResource) {
        try {
            Countries countries = countriesRepository.save(COUNTRIES_MAPPER.fromCountriesResource(countriesResource));
            countriesResource.setCode(countries.getCode());
            return countriesResource;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Country with code " + countriesResource.getCode() + " already exists.");
        }
    }

    @Override
    public CountriesResource update(CountriesResource countriesResource, String code) {
        try {
            Countries countries = countriesRepository.getReferenceById(code);

            countries.setName(countriesResource.getName());
            countries.setLocation(countriesResource.getLocation());
            countries.setAllowed(countriesResource.getAllowed());

            return COUNTRIES_MAPPER.toCountriesResource(countriesRepository.save(countries));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Unable to find country with code " + code + ".");
        }
    }

    @Override
    public void deleteById(String code) {
        if (countriesRepository.existsById(code)) {
            countriesRepository.deleteById(code);
        } else {
            throw new EntityNotFoundException("Unable to find country with code " + code + ".");
        }
    }
}