package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.FilmDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.Film;
import com.elj.gestioncinema.repositories.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService{
    FilmRepository filmRepository;
    ModelMapper modelMapper;

    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmDto save(FilmDto filmDto) {
        Film film = modelMapper.map(filmDto, Film.class);
        Film saved = filmRepository.save(film);
        return modelMapper.map(saved, FilmDto.class);
    }

    @Override
    public FilmDto findById(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Film Not Found"));
        return modelMapper.map(film, FilmDto.class);
    }

    @Override
    public FilmDto findByTitre(String titre) {
        Optional<Film> film = filmRepository.findFilmByTitre(titre);
        return modelMapper.map(film, FilmDto.class);
    }

    @Override
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public FilmDto update(FilmDto filmDto, Long id) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if(filmOptional.isPresent()) {
            Film film = modelMapper.map(filmDto, Film.class);
            film.setId(id);
            Film updated = filmRepository.save(film);
            return modelMapper.map(updated, FilmDto.class);
        } else {
            throw new EntityNotFoundException("Film Not Found");
        }
    }

    @Override
    public List<FilmDto> findAll() {
        return filmRepository.findAll().stream()
                .map(el->modelMapper.map(el,FilmDto.class))
                .collect(Collectors.toList());
    }
}
