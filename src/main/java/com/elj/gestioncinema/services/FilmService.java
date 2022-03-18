package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.FilmDto;

import java.util.List;

public interface FilmService {
    FilmDto save(FilmDto filmDto);

    FilmDto findById(Long id);

    FilmDto findByTitre(String titre);

    void delete(Long id);

    FilmDto update(FilmDto filmDto, Long id);

    List<FilmDto> findAll();
}
