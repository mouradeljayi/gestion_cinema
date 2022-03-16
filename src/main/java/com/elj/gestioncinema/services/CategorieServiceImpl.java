package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.CategorieDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Categorie;
import com.elj.gestioncinema.repositories.CategorieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService{

    private final CategorieRepository categorieRepository;
    private final ModelMapper modelMapper;

    public CategorieServiceImpl(CategorieRepository categorieRepository, ModelMapper modelMapper) {
        this.categorieRepository = categorieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategorieDto save(CategorieDto categorieDto) {
        Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
        Categorie saved = categorieRepository.save(categorie);
        return modelMapper.map(saved, CategorieDto.class);
    }

    @Override
    public CategorieDto findById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Categorie Not Found"));
        return modelMapper.map(categorie, CategorieDto.class);
    }

    @Override
    public CategorieDto findByName(String name) {
        Optional<Categorie> categorie = categorieRepository.findCategorieByName(name);
        return modelMapper.map(categorie, CategorieDto.class);
    }

    @Override
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public CategorieDto update(CategorieDto categorieDto, Long id) {
        Optional<Categorie> categorieOptional = categorieRepository.findById(id);
        if(categorieOptional.isPresent()) {
            Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
            categorie.setId(id);
            Categorie updated = categorieRepository.save(categorie);
            return modelMapper.map(updated, CategorieDto.class);
        } else {
            throw new EntityNotFoundException("Categorie Not Found");
        }

    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(el->modelMapper.map(el,CategorieDto.class))
                .collect(Collectors.toList());
    }
}
