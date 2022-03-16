package com.elj.gestioncinema.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public class CategorieDto {
    @NotBlank
    private String name;
    @NotNull
    private Collection<FilmDto> films;

}
