package com.example.bigjavahomework.mappers;

import com.example.bigjavahomework.resources.AddressesResource;
import com.example.bigjavahomework.entityes.Addresses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressesMapper {
    AddressesMapper ADDRESSES_MAPPER = Mappers.getMapper(AddressesMapper.class);
    Addresses fromAddressesResource(AddressesResource addressesResource);

    AddressesResource toAddressesResource(Addresses addresses);

    List<AddressesResource> toAddressesResources(List<Addresses> addresses);
}
