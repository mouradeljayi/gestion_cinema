package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Ville;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Long>{

    Optional<Ville> findVilleByName(String name);
}
