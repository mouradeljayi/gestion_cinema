package com.elj.gestioncinema.services.strategy;

import com.elj.gestioncinema.dto.FilmDto;
import com.elj.gestioncinema.services.FilmService;
import com.elj.gestioncinema.services.FlickrService;
import com.flickr4java.flickr.FlickrException;
import org.springframework.stereotype.Service;


import java.io.InputStream;

@Service("filmStrategy")
public class SaveFilmPhoto implements Strategy<FilmDto> {

    private final FlickrService flickrService;
    private final FilmService filmService;

    public SaveFilmPhoto(FlickrService flickrService, FilmService filmService) {
        this.flickrService = flickrService;
        this.filmService = filmService;
    }

    @Override
    public FilmDto savePhoto(Long id, InputStream photo, String titre) throws FlickrException {
        FilmDto film = filmService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        film.setPhoto(urlPhoto);
        return filmService.save(film);
    }
}
