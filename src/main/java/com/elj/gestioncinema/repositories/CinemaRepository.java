package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    Cinema findCinemaByName(String name);
}
