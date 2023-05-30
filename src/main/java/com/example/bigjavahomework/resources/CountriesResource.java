package com.example.bigjavahomework.resources;

import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class CountriesResource {
    private String code;
    private String name;
    private Boolean location;
    private Boolean allowed;
}