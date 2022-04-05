package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.ProjectionDto;
import com.elj.gestioncinema.services.ProjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("projections")
public class ProjectionController {

    ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @PostMapping("")
    public ResponseEntity<ProjectionDto> save(@Valid @RequestBody ProjectionDto projectionDto) {
        return new ResponseEntity<>(projectionService.save(projectionDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProjectionDto> findById(@PathVariable Long id) {
        ProjectionDto projectionDto = projectionService.findById(id);
        return ResponseEntity.ok(projectionDto);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<ProjectionDto> findByKeyword(@PathVariable String keyword) {
        ProjectionDto projectionDto = projectionService.findByKeyword(keyword);
        return ResponseEntity.ok(projectionDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        projectionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectionDto> update(@Valid @RequestBody ProjectionDto projectionDto, @PathVariable Long id) {
        ProjectionDto projection = projectionService.update(projectionDto, id);
        return ResponseEntity.accepted().body(projection);
    }

    @GetMapping("")
    public ResponseEntity<List<ProjectionDto>> getProjections() {
        return new ResponseEntity<>(projectionService.findAll(), HttpStatus.OK);
    }
}
