package com.elj.gestioncinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomClient;
    private double prix;
    @Column(unique = true)
    private int codePayement;
    private boolean reserve;
    @ManyToOne
    private Place place;

}
