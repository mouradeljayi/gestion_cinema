package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.CinemaRequestDto;
import com.elj.gestioncinema.dto.CinemaResponseDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Cinema;
import com.elj.gestioncinema.repositories.CinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final ModelMapper modelMapper;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CinemaResponseDto save(CinemaRequestDto cinemaRequestDto) {
        Cinema cinema = modelMapper.map(cinemaRequestDto, Cinema.class);
        Cinema saved = cinemaRepository.save(cinema);
        return modelMapper.map(saved, CinemaResponseDto.class);
    }

    @Override
    public CinemaResponseDto findById(Long id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Cinema Not Found"));
        return modelMapper.map(cinema, CinemaResponseDto.class);
    }

    @Override
    public CinemaResponseDto findByName(String name) {
        Optional<Cinema> cinema = cinemaRepository.findCinemaByName(name);
        return modelMapper.map(cinema, CinemaResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public CinemaResponseDto update(CinemaRequestDto cinemaRequestDto, Long id) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
        if(cinemaOptional.isPresent()) {
            Cinema cinema = modelMapper.map(cinemaRequestDto, Cinema.class);
            cinema.setId(id);
            Cinema updated = cinemaRepository.save(cinema);
            return modelMapper.map(updated, CinemaResponseDto.class);
        } else {
            throw new EntityNotFoundException("Cinema Not Found");
        }

    }

    @Override
    public List<CinemaResponseDto> findAll() {
        return cinemaRepository.findAll().stream()
                .map(el->modelMapper.map(el,CinemaResponseDto.class))
                .collect(Collectors.toList());
    }
}
