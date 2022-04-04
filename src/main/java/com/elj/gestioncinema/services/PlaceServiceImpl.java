package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.PlaceDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Place;
import com.elj.gestioncinema.repositories.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService{

    PlaceRepository placeRepository;
    ModelMapper modelMapper;

    public PlaceServiceImpl(PlaceRepository placeRepository, ModelMapper modelMapper) {
        this.placeRepository = placeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PlaceDto save(PlaceDto placeDto) {
        Place place = modelMapper.map(placeDto, Place.class);
        Place saved = placeRepository.save(place);
        return modelMapper.map(saved, PlaceDto.class);
    }

    @Override
    public PlaceDto findById(Long id) {
        Place place = placeRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Place Not Found"));
        return modelMapper.map(place, PlaceDto.class);
    }

    @Override
    public PlaceDto findByNumero(int numero) {
        Optional<Place> place = placeRepository.findPlaceByNumero(numero);
        return modelMapper.map(place, PlaceDto.class);
    }

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public PlaceDto update(PlaceDto placeDto, Long id) {
        Optional<Place> placeOptional = placeRepository.findById(id);
        if(placeOptional.isPresent()) {
            Place place = modelMapper.map(placeDto, Place.class);
            place.setId(id);
            Place updated = placeRepository.save(place);
            return modelMapper.map(updated, PlaceDto.class);
        } else {
            throw new EntityNotFoundException("Place Not Found");
        }
    }

    @Override
    public List<PlaceDto> findAll() {
        return placeRepository.findAll().stream()
                .map(el->modelMapper.map(el,PlaceDto.class))
                .collect(Collectors.toList());
    }
}
