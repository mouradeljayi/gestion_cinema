package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.CinemaDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Cinema;
import com.elj.gestioncinema.repositories.CinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService{

    CinemaRepository cinemaRepository;
    ModelMapper modelMapper;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CinemaDto save(CinemaDto cinemaDto) {
        Cinema cinema = modelMapper.map(cinemaDto, Cinema.class);
        Cinema saved = cinemaRepository.save(cinema);
        return modelMapper.map(saved, CinemaDto.class);
    }

    @Override
    public CinemaDto findById(Long id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Cinema Not Found"));
        return modelMapper.map(cinema, CinemaDto.class);
    }

    @Override
    public CinemaDto findByName(String name) {
        Optional<Cinema> cinema = cinemaRepository.findCinemaByName(name);
        return modelMapper.map(cinema, CinemaDto.class);
    }

    @Override
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public CinemaDto update(CinemaDto cinemaDto, Long id) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
        if(cinemaOptional.isPresent()) {
            Cinema cinema = modelMapper.map(cinemaDto, Cinema.class);
            cinema.setId(id);
            Cinema updated = cinemaRepository.save(cinema);
            return modelMapper.map(updated, CinemaDto.class);
        } else {
            throw new EntityNotFoundException("Cinema Not Found");
        }
    }

    @Override
    public List<CinemaDto> findAll() {
        return cinemaRepository.findAll().stream()
                .map(el->modelMapper.map(el,CinemaDto.class))
                .collect(Collectors.toList());
    }
}
