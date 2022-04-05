package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.SeanceDto;
import com.elj.gestioncinema.services.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("seances")
public class SeanceController {

    SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @PostMapping("")
    public ResponseEntity<SeanceDto> save(@Valid @RequestBody SeanceDto seanceDto) {
        return new ResponseEntity<>(seanceService.save(seanceDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<SeanceDto> findById(@PathVariable Long id) {
        SeanceDto seanceDto = seanceService.findById(id);
        return ResponseEntity.ok(seanceDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        seanceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SeanceDto> update(@Valid @RequestBody SeanceDto seanceDto, @PathVariable Long id) {
        SeanceDto seance = seanceService.update(seanceDto, id);
        return ResponseEntity.accepted().body(seance);
    }

    @GetMapping("")
    public ResponseEntity<List<SeanceDto>> getSeances() {
        return new ResponseEntity<>(seanceService.findAll(), HttpStatus.OK);
    }
}
