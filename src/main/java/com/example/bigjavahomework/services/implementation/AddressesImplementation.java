package com.example.bigjavahomework.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.AddressesResource;
import com.example.bigjavahomework.entityes.Addresses;
import com.example.bigjavahomework.repositoryes.AddressesRepository;
import com.example.bigjavahomework.services.AddressesService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bigjavahomework.mappers.AddressesMapper.ADDRESSES_MAPPER;

@Service
@RequiredArgsConstructor
public class AddressesImplementation implements AddressesService {
    private final AddressesRepository addressesRepository;

    @Override
    public List<AddressesResource> getAll() {
        return ADDRESSES_MAPPER.toAddressesResources(addressesRepository.findAll());
    }

    @Override
    public Optional<AddressesResource> getById(Integer id) {
        return addressesRepository.findById(id).map(ADDRESSES_MAPPER::toAddressesResource);
    }

    @Override
    public AddressesResource create(AddressesResource addressesResource) {
        try {
            Addresses addresses = addressesRepository.save(ADDRESSES_MAPPER.fromAddressesResource(addressesResource));
            addressesResource.setId(addresses.getId());
            return addressesResource;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Address with id " + addressesResource.getId() + " already exists.");
        }
    }

    @Override
    public AddressesResource update(AddressesResource addressesResource, Integer id) {
        try {
            Addresses addresses = addressesRepository.getReferenceById(id);

            addresses.setCity(addressesResource.getCity());
            addresses.setStreet(addressesResource.getStreet());
            addresses.setCountry(addressesResource.getCountry());

            return ADDRESSES_MAPPER.toAddressesResource(addressesRepository.save(addresses));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Unable to find address with id " + id + ".");
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (addressesRepository.existsById(id)) {
            addressesRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Unable to find address with id " + id + ".");
        }
    }
}