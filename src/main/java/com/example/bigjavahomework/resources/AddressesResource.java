package com.example.bigjavahomework.resources;

import com.example.bigjavahomework.entityes.Countries;
import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class AddressesResource {
    private Integer id;
    private Countries country;
    private String city;
    private String street;
}