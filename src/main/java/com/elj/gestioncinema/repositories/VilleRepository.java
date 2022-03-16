package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Ville;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Long>{
    
}
