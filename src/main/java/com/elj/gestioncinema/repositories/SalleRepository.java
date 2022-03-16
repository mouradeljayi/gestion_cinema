package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Salle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {
    
}
