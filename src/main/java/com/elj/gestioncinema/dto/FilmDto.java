package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class FilmDto {
    private Long id;
    @NotBlank
    private String titre;
    private String description;
    private String realisateur;
    private Date dateSortie;
    private double duree;
    private String photo;
    @NotNull
    private CategorieDto categorie;
}
