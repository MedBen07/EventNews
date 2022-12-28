package com.example.eventnews.repository;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    @Query("SELECT s FROM Adresse s WHERE s.idAdresse = ?1")
    Optional<Adresse> findAdresseById(Long id);

}
