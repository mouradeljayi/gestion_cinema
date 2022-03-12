package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    
}
