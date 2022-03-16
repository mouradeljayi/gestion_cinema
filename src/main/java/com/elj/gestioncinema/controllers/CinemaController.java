package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.CinemaRequestDto;
import com.elj.gestioncinema.dto.CinemaResponseDto;
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

    @GetMapping("")
    public ResponseEntity<List<CinemaResponseDto>>  getCinemas() {
        return new ResponseEntity<>(cinemaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CinemaResponseDto>  save(@Valid @RequestBody CinemaRequestDto cinemaRequestDto) {
        return new ResponseEntity<>(cinemaService.save(cinemaRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CinemaResponseDto>  findById(@PathVariable("id") Long id) {
        CinemaResponseDto cinemaResponseDto = cinemaService.findById(id);
        return ResponseEntity.ok(cinemaResponseDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CinemaResponseDto> findByName(@PathVariable() String name) {
        CinemaResponseDto cinemaResponseDto = cinemaService.findByName(name);
        return ResponseEntity.ok(cinemaResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        cinemaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CinemaResponseDto> update(@Valid @RequestBody() CinemaRequestDto cinemaRequestDto, @PathVariable() Long id) {
        CinemaResponseDto cinemaResponseDto = cinemaService.update(cinemaRequestDto, id);
        return ResponseEntity.accepted().body(cinemaResponseDto);
    }

}
