package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.PlaceDto;

import java.util.List;

public interface PlaceService {
    PlaceDto save(PlaceDto placeDto);

    PlaceDto findById(Long id);

    PlaceDto findByNumero(int numero);

    void delete(Long id);

    PlaceDto update(PlaceDto placeDto, Long id);

    List<PlaceDto> findAll();
}
