package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place,Long> {
    
}
