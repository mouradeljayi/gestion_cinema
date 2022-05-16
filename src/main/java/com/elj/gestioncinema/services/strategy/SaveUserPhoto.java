package com.elj.gestioncinema.services.strategy;

import com.elj.gestioncinema.dto.UserResponseDto;
import com.elj.gestioncinema.services.FlickrService;
import com.elj.gestioncinema.services.UserService;
import com.flickr4java.flickr.FlickrException;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service("userStrategy")
public class SaveUserPhoto implements Strategy<UserResponseDto> {

    private final FlickrService flickrService;
    private final UserService userService;

    public SaveUserPhoto(FlickrService flickrService, UserService userService) {
        this.flickrService = flickrService;
        this.userService = userService;
    }

    @Override
    public UserResponseDto savePhoto(Long id, InputStream photo, String titre) throws FlickrException {
        UserResponseDto user = userService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        user.setPhoto(urlPhoto);
        return userService.save(user);
    }
}
