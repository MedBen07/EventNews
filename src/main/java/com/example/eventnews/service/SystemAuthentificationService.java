package com.example.eventnews.service;

import com.example.eventnews.model.Evenement;
import com.example.eventnews.model.SystemAuthentification;
import com.example.eventnews.repository.EvenementRepository;
import com.example.eventnews.repository.SystemAuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SystemAuthentificationService {

    @Autowired
    private SystemAuthentificationRepository systemAuthentificationRepository;
    /**
     * Trouve la liste des systemAuthentification dans la bd.
     * @return la liste des systemAuthentification.
     */
    public List<SystemAuthentification> getSystemAuthentification() {
        return systemAuthentificationRepository.findAll();
    }
    /**
     * Sauvegarde le systemAuthentification dans la bd
     * @param systemAuthentification
     */
    public void save(SystemAuthentification systemAuthentification) {
        systemAuthentificationRepository.save(systemAuthentification);
    }
    /**
     * Cherche par id une systemAuthentification
     * @param id du systemAuthentification cherché
     * @return le systemAuthentification cherché
     */
    public SystemAuthentification get(Long id) {
        return systemAuthentificationRepository.findById(id).get();
    }
    /**
     * Supprime un systemAuthentification par id
     * @param id de systemAuthentification à supprimer
     */
    public void delete(Long id) {
        systemAuthentificationRepository.deleteById(id);
    }

    public void addNewSystemAuthentification(SystemAuthentification systemAuthentification) {
        Optional<SystemAuthentification> billetOptional = systemAuthentificationRepository.findSystemAuthentificationById(systemAuthentification.getIdAuthentification());
        if(billetOptional.isPresent()){
            throw new IllegalStateException("Authentification existe!");
        }
        systemAuthentificationRepository.save(systemAuthentification);
    }
}
