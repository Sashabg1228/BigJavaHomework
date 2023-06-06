package com.example.bigjavahomework.mappers;

import com.example.bigjavahomework.resources.CountriesResource;
import com.example.bigjavahomework.entityes.Countries;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountriesMapper {
    CountriesMapper COUNTRIES_MAPPER = Mappers.getMapper(CountriesMapper.class);

    Countries fromCountriesResource(CountriesResource countriesResource);

    CountriesResource toCountriesResource(Countries countries);

    List<CountriesResource> toCountriesResources(List<Countries> countries);
}
