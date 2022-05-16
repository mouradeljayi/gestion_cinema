package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.UserRequestDto;
import com.elj.gestioncinema.dto.UserResponseDto;

import java.util.List;


public interface UserService {

    UserResponseDto save(UserResponseDto cinemaRequestDto);

    UserResponseDto findById(Long id);

    UserResponseDto findByUsername(String username);

    void delete(Long id);

    UserResponseDto update(UserRequestDto cinemaRequestDto, Long id);

    List<UserResponseDto> findAll();
}
