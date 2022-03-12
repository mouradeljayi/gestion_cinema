package com.elj.gestioncinema.dto;

import com.elj.gestioncinema.model.Salle;
import com.elj.gestioncinema.model.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaResponseDto {
    private Long id;
    private String name;
    private double longitude, latitude, altitude;
    private int nombreSalles;
    private Collection<Salle> salles;
    private Ville ville;
}
