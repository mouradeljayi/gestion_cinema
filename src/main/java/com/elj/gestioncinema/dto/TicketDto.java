package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TicketDto {
    private String nomClient;
    private double prix;
    private int codePayement;
    private boolean reserve;
    private PlaceDto place;
    private ProjectionDto projection;
}
