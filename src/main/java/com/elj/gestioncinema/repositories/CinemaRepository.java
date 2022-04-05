package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long>{

    Optional<Cinema> findCinemaByName(String name);
}
