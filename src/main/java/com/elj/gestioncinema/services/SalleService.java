package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.SalleDto;

import java.util.List;

public interface SalleService {
    SalleDto save(SalleDto salleDto);

    SalleDto findById(Long id);

    SalleDto findByName(String name);

    void delete(Long id);

    SalleDto update(SalleDto salleDto, Long id);

    List<SalleDto> findAll();
}
