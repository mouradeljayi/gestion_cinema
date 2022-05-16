package com.elj.gestioncinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String photo;
    private String email;
    private String password;
}
