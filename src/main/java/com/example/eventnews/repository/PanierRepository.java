package com.example.eventnews.repository;

import com.example.eventnews.model.Categorie;
import com.example.eventnews.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

    @Query("SELECT s FROM Panier s WHERE s.idPanier = ?1")
    Optional<Panier> findPanierById(Long id);

}
