package com.elj.gestioncinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75, unique = true)
    private String name;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private Collection<Film> films;
}
