package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.CinemaRequestDto;
import com.elj.gestioncinema.dto.CinemaResponseDto;

import java.util.List;


public interface CinemaService {

    CinemaResponseDto save(CinemaRequestDto cinemaRequestDto);

    CinemaResponseDto findById(Long id);

    CinemaResponseDto findByName(String name);

    void delete(Long id);

    CinemaResponseDto update(CinemaRequestDto cinemaRequestDto, Long id);

    List<CinemaResponseDto> findAll();
}
