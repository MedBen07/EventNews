package com.example.eventnews.repository;

import com.example.eventnews.model.Panier;
import com.example.eventnews.model.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    @Query("SELECT s FROM Visiteur s WHERE s.idVisiteur = ?1")
    Optional<Visiteur> findVisiteurById(Long id);
    
}
