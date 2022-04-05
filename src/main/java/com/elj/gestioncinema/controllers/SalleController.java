package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.SalleDto;
import com.elj.gestioncinema.services.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("salles")
public class SalleController {

    SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @PostMapping("")
    public ResponseEntity<SalleDto> save(@Valid @RequestBody SalleDto salleDto) {
        return new ResponseEntity<>(salleService.save(salleDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<SalleDto> findById(@PathVariable Long id) {
        SalleDto salleDto = salleService.findById(id);
        return ResponseEntity.ok(salleDto);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<SalleDto> findByName(@PathVariable String name) {
        SalleDto salleDto = salleService.findByName(name);
        return ResponseEntity.ok(salleDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        salleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SalleDto> update(@Valid @RequestBody SalleDto salleDto, @PathVariable Long id) {
        SalleDto salle = salleService.update(salleDto, id);
        return ResponseEntity.accepted().body(salle);
    }

    @GetMapping("")
    public ResponseEntity<List<SalleDto>> getSalles() {
        return new ResponseEntity<>(salleService.findAll(), HttpStatus.OK);
    }
}
