package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Seance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance,Long> {
    
}
