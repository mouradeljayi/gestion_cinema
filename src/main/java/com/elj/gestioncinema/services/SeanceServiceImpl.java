package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.SeanceDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Seance;
import com.elj.gestioncinema.repositories.SeanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeanceServiceImpl implements SeanceService{

    SeanceRepository seanceRepository;
    ModelMapper modelMapper;

    public SeanceServiceImpl(SeanceRepository seanceRepository, ModelMapper modelMapper) {
        this.seanceRepository = seanceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SeanceDto save(SeanceDto seanceDto) {
        Seance seance = modelMapper.map(seanceDto, Seance.class);
        Seance saved = seanceRepository.save(seance);
        return modelMapper.map(saved, SeanceDto.class);
    }

    @Override
    public SeanceDto findById(Long id) {
        Seance seance = seanceRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Seance Not Found"));
        return modelMapper.map(seance, SeanceDto.class);
    }

    @Override
    public void delete(Long id) {
        seanceRepository.deleteById(id);
    }

    @Override
    public SeanceDto update(SeanceDto seanceDto, Long id) {
        Optional<Seance> seanceOptional = seanceRepository.findById(id);
        if(seanceOptional.isPresent()) {
            Seance seance = modelMapper.map(seanceDto, Seance.class);
            seance.setId(id);
            Seance updated = seanceRepository.save(seance);
            return modelMapper.map(updated, SeanceDto.class);
        } else {
            throw new EntityNotFoundException("Seance Not Found");
        }
    }

    @Override
    public List<SeanceDto> findAll() {
        return seanceRepository.findAll().stream()
                .map(el->modelMapper.map(el,SeanceDto.class))
                .collect(Collectors.toList());
    }
}
