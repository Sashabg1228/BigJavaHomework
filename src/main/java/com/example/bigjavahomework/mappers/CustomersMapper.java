package com.example.bigjavahomework.mappers;

import com.example.bigjavahomework.resources.CustomersResource;
import com.example.bigjavahomework.entityes.Customers;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomersMapper {
    CustomersMapper CUSTOMERS_MAPPER = Mappers.getMapper(CustomersMapper.class);

    Customers fromCustomersResource(CustomersResource customersResource);

    CustomersResource toCustomersResource(Customers customers);

    List<CustomersResource> toCustomersResources(List<Customers> customers);
}