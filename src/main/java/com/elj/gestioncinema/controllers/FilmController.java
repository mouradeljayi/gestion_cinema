package com.elj.gestioncinema.controllers;


import com.elj.gestioncinema.dto.FilmDto;
import com.elj.gestioncinema.services.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/films")
public class FilmController {

    FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/create")
    public ResponseEntity<FilmDto> save(@Valid @RequestBody FilmDto filmDto) {
        return new ResponseEntity<>(filmService.save(filmDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> findById(@PathVariable("id") Long id) {
        FilmDto filmDto = filmService.findById(id);
        return ResponseEntity.ok(filmDto);
    }

    @GetMapping("/search/{titre}")
    public ResponseEntity<FilmDto> findByTitre(@PathVariable String titre) {
        FilmDto filmDto = filmService.findByTitre(titre);
        return ResponseEntity.ok(filmDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FilmDto> update(@Valid @RequestBody FilmDto filmDto, @PathVariable Long id) {
        FilmDto film = filmService.update(filmDto, id);
        return ResponseEntity.accepted().body(film);
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ResponseEntity<List<FilmDto>> getFilms() {
        return new ResponseEntity<>(filmService.findAll(), HttpStatus.OK);
    }
}
