package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    Optional<Film> findFilmByTitre(String titre);
}
