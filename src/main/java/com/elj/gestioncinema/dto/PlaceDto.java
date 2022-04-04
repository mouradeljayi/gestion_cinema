package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class PlaceDto {
    private int numero;
    private double longitude, latitude, altitude;
    private SalleDto salle;
    private List<TicketDto> tickets;
}
