package com.elj.gestioncinema.dto;

import com.elj.gestioncinema.model.Salle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectionDto {
    @NotBlank
    private Date dateProjection;
    private double prix;
    private Salle salle;
    private FilmDto film;
    private List<TicketDto> tickets;
    private SeanceDto seance;
}
