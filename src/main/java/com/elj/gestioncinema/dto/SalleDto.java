package com.elj.gestioncinema.dto;

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
    private UserDto cinema;
    private List<PlaceDto> places;
    private FilmDto film;
}
