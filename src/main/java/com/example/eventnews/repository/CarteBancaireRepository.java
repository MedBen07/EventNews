package com.example.eventnews.repository;

import com.example.eventnews.model.Billet;
import com.example.eventnews.model.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {

    @Query("SELECT s FROM CarteBancaire s WHERE s.numCarte = ?1")
    Optional<CarteBancaire> findBilletByNumCarte(Long numCarte);


}
