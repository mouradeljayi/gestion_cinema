package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection,Long> {
    Optional<Projection> findProjectionBySeanceOrFilmOrSalle(String keyword);
}
