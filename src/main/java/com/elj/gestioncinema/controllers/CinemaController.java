package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.CinemaDto;
import com.elj.gestioncinema.services.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cinemas")
public class CinemaController {

    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping("")
    public ResponseEntity<CinemaDto> save(@Valid @RequestBody CinemaDto cinemaDto) {
        return new ResponseEntity<>(cinemaService.save(cinemaDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CinemaDto> findById(@PathVariable Long id) {
        CinemaDto cinemaDto = cinemaService.findById(id);
        return ResponseEntity.ok(cinemaDto);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CinemaDto> findByName(@PathVariable String name) {
        CinemaDto cinemaDto = cinemaService.findByName(name);
        return ResponseEntity.ok(cinemaDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cinemaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CinemaDto> update(@Valid @RequestBody CinemaDto cinemaDto, @PathVariable Long id) {
        CinemaDto cinema = cinemaService.update(cinemaDto, id);
        return ResponseEntity.accepted().body(cinema);
    }

    @GetMapping("")
    public ResponseEntity<List<CinemaDto>> getCinemas() {
        return new ResponseEntity<>(cinemaService.findAll(), HttpStatus.OK);
    }
}
