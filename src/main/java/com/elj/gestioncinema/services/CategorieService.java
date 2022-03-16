package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.CategorieDto;


import java.util.List;

public interface CategorieService {
    CategorieDto save(CategorieDto categorieDto);

    CategorieDto findById(Long id);

    CategorieDto findByName(String name);

    void delete(Long id);

    CategorieDto update(CategorieDto categorieDto, Long id);

    List<CategorieDto> findAll();
}
