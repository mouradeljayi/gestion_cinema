package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategorieDto {
    @NotBlank
    private String name;
    @NotNull
    private Collection<FilmDto> films;

}
