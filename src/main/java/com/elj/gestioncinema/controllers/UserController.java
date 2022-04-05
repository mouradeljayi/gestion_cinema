package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.dto.UserRequestDto;
import com.elj.gestioncinema.dto.UserResponseDto;
import com.elj.gestioncinema.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>>  getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDto>  save(@Valid @RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.save(userRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserResponseDto>  findById(@PathVariable("id") Long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDto> findByUsername(@PathVariable String username) {
        UserResponseDto userResponseDto = userService.findByUsername(username);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> update(@Valid @RequestBody UserRequestDto userRequestDto, @PathVariable Long id) {
        UserResponseDto userResponseDto = userService.update(userRequestDto, id);
        return ResponseEntity.accepted().body(userResponseDto);
    }

}
