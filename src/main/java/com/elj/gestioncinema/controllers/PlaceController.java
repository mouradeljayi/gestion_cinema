package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.FilmDto;
import com.elj.gestioncinema.dto.PlaceDto;
import com.elj.gestioncinema.model.Place;
import com.elj.gestioncinema.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class PlaceController {

    PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("")
    public ResponseEntity<PlaceDto> save(@Valid @RequestBody PlaceDto placeDto) {
        return new ResponseEntity<>(placeService.save(placeDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<PlaceDto> findById(@PathVariable Long id) {
        PlaceDto placeDto = placeService.findById(id);
        return ResponseEntity.ok(placeDto);
    }

    @GetMapping("/search/{titre}")
    public ResponseEntity<PlaceDto> findByNumero(@PathVariable int numero) {
        PlaceDto placeDto = placeService.findByNumero(numero);
        return ResponseEntity.ok(placeDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        placeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlaceDto> update(@Valid @RequestBody PlaceDto placeDto, @PathVariable Long id) {
        PlaceDto place = placeService.update(placeDto, id);
        return ResponseEntity.accepted().body(place);
    }

    @GetMapping("")
    public ResponseEntity<List<PlaceDto>> getPlaces() {
        return new ResponseEntity<>(placeService.findAll(), HttpStatus.OK);
    }
}
