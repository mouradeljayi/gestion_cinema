package com.elj.gestioncinema.services.strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StrategyPhotoContext {


    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public StrategyPhotoContext(String context) {

    }

    public Object savePhoto(String context, Long id, InputStream photo, String title) throws FlickrException {
        determineContext(context);
        return strategy.savePhoto(id, photo, title);
    }

    private void determineContext(String context) {
        final String beanName = context + "Strategy";
        switch (context) {
            case "film" -> strategy = beanFactory.getBean(beanName, SaveFilmPhoto.class);
            case "user" -> strategy = beanFactory.getBean(beanName, SaveUserPhoto.class);
            default -> System.out.println("Error");
        }
    }
}
