package com.elj.gestioncinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private double longitude, latitude, altitude;
    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private Collection<Cinema> cinemas;
}
