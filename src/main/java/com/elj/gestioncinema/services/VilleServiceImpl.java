package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.VilleDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Ville;
import com.elj.gestioncinema.repositories.VilleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VilleServiceImpl implements VilleService{

    VilleRepository villeRepository;
    ModelMapper modelMapper;

    public VilleServiceImpl(VilleRepository villeRepository, ModelMapper modelMapper) {
        this.villeRepository = villeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VilleDto save(VilleDto villeDto) {
        Ville ville = modelMapper.map(villeDto, Ville.class);
        Ville saved = villeRepository.save(ville);
        return modelMapper.map(saved, VilleDto.class);
    }

    @Override
    public VilleDto findById(Long id) {
        Ville ville = villeRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Ville Not Found"));
        return modelMapper.map(ville, VilleDto.class);
    }

    @Override
    public VilleDto findByName(String name) {
        Optional<Ville> ville = villeRepository.findVilleByName(name);
        return modelMapper.map(ville, VilleDto.class);
    }

    @Override
    public void delete(Long id) {
        villeRepository.deleteById(id);
    }

    @Override
    public VilleDto update(VilleDto villeDto, Long id) {
        Optional<Ville> villeOptional = villeRepository.findById(id);
        if(villeOptional.isPresent()) {
            Ville ville = modelMapper.map(villeDto, Ville.class);
            ville.setId(id);
            Ville updated = villeRepository.save(ville);
            return modelMapper.map(updated, VilleDto.class);
        } else {
            throw new EntityNotFoundException("Ville Not Found");
        }
    }

    @Override
    public List<VilleDto> findAll() {
        return villeRepository.findAll().stream()
                .map(el->modelMapper.map(el,VilleDto.class))
                .collect(Collectors.toList());
    }
}
