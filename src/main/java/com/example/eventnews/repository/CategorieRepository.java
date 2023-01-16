package com.example.eventnews.repository;

import com.example.eventnews.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Cette interface est responsable d’accéder à la bd
 *
 */
@Repository //Pour indiquer que c’est la couche qui a accès a la bd
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    @Query("SELECT s FROM Categorie s WHERE s.idCategorie = ?1")
    Optional<Categorie> findCategorieById(Long id);

}
