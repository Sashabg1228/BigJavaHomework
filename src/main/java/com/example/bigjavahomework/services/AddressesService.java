package com.example.bigjavahomework.services;

import com.example.bigjavahomework.entityes.Addresses;
import java.util.List;

public interface AddressesService {
    List<Addresses> allAddresses();
    Addresses findById(Integer id);
    Addresses save(Addresses addresses);
    Addresses update(Addresses addresses);
    void deleteById(Integer id);
}