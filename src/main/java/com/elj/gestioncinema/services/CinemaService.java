package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.CinemaDto;

import java.util.List;

public interface CinemaService {
    CinemaDto save(CinemaDto cinemaDto);

    CinemaDto findById(Long id);

    CinemaDto findByName(String name);

    void delete(Long id);

    CinemaDto update(CinemaDto cinemaDto, Long id);

    List<CinemaDto> findAll();
}
