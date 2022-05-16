package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategorieDto {
    private Long id;
    @NotBlank(message = "le champ name ne doit pas étre vide")
    private String name;
    //private List<FilmDto> films;

}
