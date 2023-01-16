package com.example.eventnews.repository;

import com.example.eventnews.model.SystemAuthentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Cette interface est responsable d’accéder à la bd
 *
 */
@Repository //Pour indiquer que c’est la couche qui a accès a la bd
public interface SystemAuthentificationRepository extends JpaRepository<SystemAuthentification, Long> {

    @Query("SELECT s FROM SystemAuthentification s WHERE s.idAuthentification = ?1")
    Optional<SystemAuthentification> findSystemAuthentificationById(Long id);


}
