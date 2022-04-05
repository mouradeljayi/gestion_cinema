package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class CinemaDto {
    @NotBlank
    private String name;
    private double longitude, latitude, altitude;
    private int nombreSalles;
    private List<SalleDto> salles;
    private VilleDto ville;
}
