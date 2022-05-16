package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.UserDto;

import java.util.List;


public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Long id);

    UserDto findByUsername(String username);

    void delete(Long id);

    UserDto update(UserDto userDto, Long id);

    List<UserDto> findAll();
}
