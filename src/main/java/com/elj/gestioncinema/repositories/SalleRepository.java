package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Salle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {
    Optional<Salle> findSalleByName(String name);
}
