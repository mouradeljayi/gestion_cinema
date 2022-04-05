package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.ProjectionDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Projection;
import com.elj.gestioncinema.repositories.ProjectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectionServiceImpl implements ProjectionService{

    ProjectionRepository projectionRepository;
    ModelMapper modelMapper;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, ModelMapper modelMapper) {
        this.projectionRepository = projectionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectionDto save(ProjectionDto projectionDto) {
        Projection projection = modelMapper.map(projectionDto, Projection.class);
        Projection saved = projectionRepository.save(projection);
        return modelMapper.map(saved, ProjectionDto.class);
    }

    @Override
    public ProjectionDto findById(Long id) {
        Projection projection = projectionRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Projection Not Found"));
        return modelMapper.map(projection, ProjectionDto.class);
    }

    @Override
    public ProjectionDto findByKeyword(String keyword) {
        Optional<Projection> projection = projectionRepository.findProjectionBySeanceOrFilmOrSalle(keyword);
        return modelMapper.map(projection, ProjectionDto.class);
    }

    @Override
    public void delete(Long id) {
        projectionRepository.deleteById(id);
    }

    @Override
    public ProjectionDto update(ProjectionDto projectionDto, Long id) {
        Optional<Projection> projectionOptional = projectionRepository.findById(id);
        if(projectionOptional.isPresent()) {
            Projection projection = modelMapper.map(projectionDto, Projection.class);
            projection.setId(id);
            Projection updated = projectionRepository.save(projection);
            return modelMapper.map(updated, ProjectionDto.class);
        } else {
            throw new EntityNotFoundException("Projection Not Found");
        }
    }

    @Override
    public List<ProjectionDto> findAll() {
        return projectionRepository.findAll().stream()
                .map(el->modelMapper.map(el,ProjectionDto.class))
                .collect(Collectors.toList());
    }
}
