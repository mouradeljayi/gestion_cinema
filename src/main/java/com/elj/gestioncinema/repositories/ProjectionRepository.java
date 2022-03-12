package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionRepository extends JpaRepository<Projection,Long> {
    
}
