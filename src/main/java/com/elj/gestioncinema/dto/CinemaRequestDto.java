package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
public class CinemaRequestDto {
    @NotBlank
    private String name;
    @NotNull(message = "Les corodonnées géograpiques sont obligatoires")
    private double longitude, latitude, altitude;
    @NotNull
    private int nombreSalles;
    @NotNull
    private Collection<SalleDto> salles;
    @NotBlank
    private VilleDto ville;
}
