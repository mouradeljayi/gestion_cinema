package com.elj.gestioncinema.dto;

import com.elj.gestioncinema.model.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalleDto {
    private String name;
    private int nombrePlace;
    private CinemaRequestDto cinema;
    private List<PlaceDto> places;
    private List<ProjectionDto> projections;
    private FilmDto film;
}
