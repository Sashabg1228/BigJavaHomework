package com.example.bigjavahomework.mappers;

import com.example.bigjavahomework.resources.StatusesResource;
import com.example.bigjavahomework.entityes.Statuses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StatusesMapper {
    StatusesMapper STATUSES_MAPPER = Mappers.getMapper(StatusesMapper.class);

    Statuses fromStatusesResource(StatusesResource statusesResource);

    StatusesResource toStatusesResource(Statuses statuses);

    List<StatusesResource> toStatusesResources(List<Statuses> statuses);
}