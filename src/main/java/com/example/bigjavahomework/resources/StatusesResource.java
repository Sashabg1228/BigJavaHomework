package com.example.bigjavahomework.resources;

import jakarta.annotation.Resource;
import lombok.Data;

@Resource
@Data
public class StatusesResource {
    private String code;
    private String name;
}