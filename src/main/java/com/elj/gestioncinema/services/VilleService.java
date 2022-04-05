package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.VilleDto;

import java.util.List;

public interface VilleService {
    VilleDto save(VilleDto villeDto);

    VilleDto findById(Long id);

    VilleDto findByName(String name);

    void delete(Long id);

    VilleDto update(VilleDto salleDto, Long id);

    List<VilleDto> findAll();
}
