package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.CinemaRequestDto;
import com.elj.gestioncinema.dto.CinemaResponseDto;
import com.elj.gestioncinema.services.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cinemas")
public class CinemaController {

    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("")
    public List<CinemaResponseDto> getCinemas() {
        return cinemaService.findAll();
    }

    @PostMapping("")
    public CinemaResponseDto save(@RequestBody CinemaRequestDto cinemaRequestDto) {
        return cinemaService.save(cinemaRequestDto);
    }
}
