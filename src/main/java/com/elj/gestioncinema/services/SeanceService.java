package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.SeanceDto;

import java.util.List;

public interface SeanceService {
    SeanceDto save(SeanceDto seanceDto);

    SeanceDto findById(Long id);

    void delete(Long id);

    SeanceDto update(SeanceDto seanceDto, Long id);

    List<SeanceDto> findAll();
}
