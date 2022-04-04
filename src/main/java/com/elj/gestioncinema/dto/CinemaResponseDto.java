package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaResponseDto {
    private Long id;
    private String name;
    private double longitude, latitude, altitude;
    private int nombreSalles;
    private List<SalleDto> salles;
    private VilleDto ville;
}
