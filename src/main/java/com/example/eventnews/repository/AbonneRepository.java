package com.example.eventnews.repository;

import com.example.eventnews.model.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbonneRepository extends JpaRepository<Abonne, Long> {

    //LA PRESENTE INTERFACE NOUS PERMET DE DISPOSER DE TOUTES LES OPERATIONS DE BASE SUR LES DONNÉES DE L'ABONNÉ
    // AUTOMATIQUEMENT EN TOUT CE QUI CONCERNE : SAVE, MODIFICATION, RECHERCHE ET SUPPRESSION
    @Query("SELECT s FROM Abonne s WHERE s.courriel = ?1")
    Optional<Abonne> findAbonneByEmail(String email);

}
