package com.example.bigjavahomework.services.implementation;

import com.example.bigjavahomework.entityes.Addresses;
import com.example.bigjavahomework.repositoryes.AddressesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bigjavahomework.services.AddressesService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressesImplementation implements AddressesService {
    private final AddressesRepository addressesRepository;

    @Override
    public List<Addresses> allAddresses() {
        return addressesRepository.findAll();
    }

    @Override
    public Addresses save(Addresses addresses) {
        return addressesRepository.save(addresses);
    }

    @Override
    public Addresses update(Addresses addresses) {
        Addresses existingAddresses = addressesRepository.findById(addresses.getId()).orElse(null);
        if (existingAddresses != null) {
            existingAddresses.setCountry(addresses.getCountry());
            existingAddresses.setCity(addresses.getCity());
            existingAddresses.setStreet(addresses.getStreet());
            return addressesRepository.save(existingAddresses);
        }
        return addressesRepository.save(addresses);
    }

    @Override
    public void deleteById(Integer id) {
        addressesRepository.deleteById(id);
    }

    @Override
    public Addresses findById(Integer id) {
        return addressesRepository.findById(id).orElse(null);
    }
}