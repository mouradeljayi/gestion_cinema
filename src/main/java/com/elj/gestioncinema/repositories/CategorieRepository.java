package com.elj.gestioncinema.repositories;

import com.elj.gestioncinema.model.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Optional<Categorie> findCategorieByName(String name);
}
