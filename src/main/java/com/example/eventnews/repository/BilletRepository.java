package com.example.eventnews.repository;

import com.example.eventnews.model.Adresse;
import com.example.eventnews.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BilletRepository extends JpaRepository<Billet,Long> {

    @Query("SELECT s FROM Billet s WHERE s.idBillet = ?1")
    Optional<Billet> findBilletById(Long id);
}
