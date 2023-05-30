package com.example.bigjavahomework.services;

import com.example.bigjavahomework.entityes.Statuses;
import java.util.List;

public interface StatusesService {
    List<Statuses> allStatuses();
    Statuses findByCode(String code);
    Statuses save(Statuses status);
    Statuses update(Statuses status);
    void deleteByCode(String code);
}