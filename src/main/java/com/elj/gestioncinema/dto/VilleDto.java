package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class VilleDto {
    private Long id;
    private String name;
    private double longitude, latitude, altitude;
    //private List<CinemaDto> cinemas;
}
