package com.example.eventnews.repository;

import com.example.eventnews.model.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Cette interface est responsable d’accéder à la bd
 *
 */
@Repository //Pour indiquer que c’est la couche qui a accès a la bd
public interface AbonneRepository extends JpaRepository<Abonne, Long> {

    @Query("SELECT s FROM Abonne s WHERE s.courriel = ?1")
    Optional<Abonne> findAbonneByEmail(String email);

}
