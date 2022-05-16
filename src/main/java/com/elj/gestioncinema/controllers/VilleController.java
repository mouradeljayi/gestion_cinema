package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.VilleDto;
import com.elj.gestioncinema.services.VilleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/villes")
public class VilleController {

    VilleService villeService;

    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @PostMapping("/create")
    public ResponseEntity<VilleDto> save(@Valid @RequestBody VilleDto villeDto) {
        return new ResponseEntity<>(villeService.save(villeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDto> findById(@PathVariable Long id) {
        VilleDto villeDto = villeService.findById(id);
        return ResponseEntity.ok(villeDto);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<VilleDto> findByName(@PathVariable String name) {
        VilleDto villeDto = villeService.findByName(name);
        return ResponseEntity.ok(villeDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        villeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VilleDto> update(@Valid @RequestBody VilleDto villeDto, @PathVariable Long id) {
        VilleDto ville = villeService.update(villeDto, id);
        return ResponseEntity.accepted().body(ville);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VilleDto>> getVilles() {
        return new ResponseEntity<>(villeService.findAll(), HttpStatus.OK);
    }
}
