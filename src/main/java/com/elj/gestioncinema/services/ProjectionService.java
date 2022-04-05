package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.ProjectionDto;

import java.util.List;

public interface ProjectionService {
    ProjectionDto save(ProjectionDto projectionDto);

    ProjectionDto findById(Long id);

    ProjectionDto findByKeyword(String keyword);

    void delete(Long id);

    ProjectionDto update(ProjectionDto projectionDto, Long id);

    List<ProjectionDto> findAll();
}
