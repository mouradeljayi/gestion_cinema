package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.SalleDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Salle;
import com.elj.gestioncinema.repositories.SalleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalleServiceImpl implements SalleService{

    SalleRepository salleRepository;
    ModelMapper modelMapper;

    public SalleServiceImpl(SalleRepository salleRepository, ModelMapper modelMapper) {
        this.salleRepository = salleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SalleDto save(SalleDto salleDto) {
        Salle salle = modelMapper.map(salleDto, Salle.class);
        Salle saved = salleRepository.save(salle);
        return modelMapper.map(saved, SalleDto.class);
    }

    @Override
    public SalleDto findById(Long id) {
        Salle salle = salleRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Salle Not Found"));
        return modelMapper.map(salle, SalleDto.class);
    }

    @Override
    public SalleDto findByName(String name) {
        Optional<Salle> salle = salleRepository.findSalleByName(name);
        return modelMapper.map(salle, SalleDto.class);
    }

    @Override
    public void delete(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public SalleDto update(SalleDto salleDto, Long id) {
        Optional<Salle> salleOptional = salleRepository.findById(id);
        if(salleOptional.isPresent()) {
            Salle salle = modelMapper.map(salleDto, Salle.class);
            salle.setId(id);
            Salle updated = salleRepository.save(salle);
            return modelMapper.map(updated, SalleDto.class);
        } else {
            throw new EntityNotFoundException("Salle Not Found");
        }
    }

    @Override
    public List<SalleDto> findAll() {
        return salleRepository.findAll().stream()
                .map(el->modelMapper.map(el,SalleDto.class))
                .collect(Collectors.toList());
    }

}
