package com.example.bigjavahomework.services.implementation;

import com.example.bigjavahomework.entityes.Statuses;
import com.example.bigjavahomework.repositoryes.StatusesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.bigjavahomework.services.StatusesService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusesImplementation implements StatusesService {
    private final StatusesRepository statusesRepository;

    @Override
    public List<Statuses> allStatuses() {
        return statusesRepository.findAll();
    }

    @Override
    public Statuses save(Statuses status) {
        return statusesRepository.save(status);
    }

    @Override
    public Statuses update(Statuses status) {
        Statuses existingStatus = statusesRepository.findById(status.getCode()).orElse(null);
        if (existingStatus != null) {
            existingStatus.setName(status.getName());
            return statusesRepository.save(existingStatus);
        }
        return statusesRepository.save(status);
    }

    @Override
    public void deleteByCode(String code) {
        statusesRepository.deleteById(code);
    }

    @Override
    public Statuses findByCode(String code) {
        return statusesRepository.findById(code).orElse(null);
    }
}