package com.elj.gestioncinema.services;

import com.elj.gestioncinema.dto.UserRequestDto;
import com.elj.gestioncinema.dto.UserResponseDto;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.model.User;
import com.elj.gestioncinema.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto save(UserResponseDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserResponseDto.class);
    }

    @Override
    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("User Not Found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto findByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequestDto, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            User user = modelMapper.map(userRequestDto, User.class);
            user.setId(id);
            User updated = userRepository.save(user);
            return modelMapper.map(updated, UserResponseDto.class);
        } else {
            throw new EntityNotFoundException("User Not Found");
        }

    }

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream()
                .map(el->modelMapper.map(el, UserResponseDto.class))
                .collect(Collectors.toList());
    }
}
