package com.example.bigjavahomework.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.bigjavahomework.resources.StatusesResource;
import com.example.bigjavahomework.entityes.Statuses;
import com.example.bigjavahomework.repositoryes.StatusesRepository;
import com.example.bigjavahomework.services.StatusesService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bigjavahomework.mappers.StatusesMapper.STATUSES_MAPPER;

@Service
@RequiredArgsConstructor
public class StatusesImplementation implements StatusesService {
    private final StatusesRepository statusesRepository;

    @Override
    public List<StatusesResource> getAll() {
        return STATUSES_MAPPER.toStatusesResources(statusesRepository.findAll());
    }

    @Override
    public Optional<StatusesResource> getByCode(String code) {
        return statusesRepository.findById(code).map(STATUSES_MAPPER::toStatusesResource);
    }

    @Override
    public StatusesResource create(StatusesResource statusesResource) {
        try {
            Statuses statuses = statusesRepository.save(STATUSES_MAPPER.fromStatusesResource(statusesResource));
            statusesResource.setCode(statuses.getCode());
            return statusesResource;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Status with code " + statusesResource.getCode() + " already exists.");
        }
    }

    @Override
    public StatusesResource update(StatusesResource statusesResource, String code) {
        try {
            Statuses statuses = statusesRepository.getReferenceById(code);

            statuses.setName(statusesResource.getName());

            return STATUSES_MAPPER.toStatusesResource(statusesRepository.save(statuses));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Unable to find status with code " + code + ".");
        }
    }

    @Override
    public void deleteByCode(String code) {
        if (statusesRepository.existsById(code)) {
            statusesRepository.deleteById(code);
        } else {
            throw new EntityNotFoundException("Unable to find status with code " + code + ".");
        }
    }
}