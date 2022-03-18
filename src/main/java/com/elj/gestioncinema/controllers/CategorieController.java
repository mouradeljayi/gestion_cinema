package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.CategorieDto;
import com.elj.gestioncinema.services.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategorieController {

    CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("")
    public ResponseEntity<List<CategorieDto>> getCategories() {
        return new ResponseEntity<>(categorieService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CategorieDto>  save(@Valid @RequestBody CategorieDto categorieDto) {
        return new ResponseEntity<>(categorieService.save(categorieDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CategorieDto>  findById(@PathVariable("id") Long id) {
        CategorieDto categorieDto = categorieService.findById(id);
        return ResponseEntity.ok(categorieDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategorieDto> findByName(@PathVariable String name) {
        CategorieDto categorieDto = categorieService.findByName(name);
        return ResponseEntity.ok(categorieDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        categorieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategorieDto> update(@Valid @RequestBody CategorieDto categorieDto, @PathVariable Long id) {
        CategorieDto categorie = categorieService.update(categorieDto, id);
        return ResponseEntity.accepted().body(categorie);
    }

}
