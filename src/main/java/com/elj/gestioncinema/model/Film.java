package com.elj.gestioncinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titre;
    private String description;
    private String realisateur;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSortie;
    private double duree;
    private String photo;
    @ManyToOne
    private Categorie categorie;

}
