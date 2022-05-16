package com.elj.gestioncinema.controllers;

import com.elj.gestioncinema.services.strategy.StrategyPhotoContext;
import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private final StrategyPhotoContext strategyPhotoContext;

    @Autowired
    public PhotoController(StrategyPhotoContext strategyPhotoContext) {
        this.strategyPhotoContext = strategyPhotoContext;
    }

    @GetMapping("/{id}/{title}/{context}")
    Object savePhoto(String context, Long id, @RequestParam("file") MultipartFile photo, String title) throws IOException, FlickrException {
        return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
    }

}
