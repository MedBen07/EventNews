package com.example.eventnews.service;

import com.example.eventnews.model.Evenement;
import com.example.eventnews.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
/**
 * Agit comme une couche intermédiaire entre la couche
 * de persistance (repository) et la couche de contrôleur
 */
@Service
@Transactional
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;
    /**
     * Trouve la liste des Evenement dans la bd.
     * @return la liste des Evenement.
     */
    public List<Evenement> getEvenement() {
        return evenementRepository.findAll();
    }
    /**
     * Sauvegarde le Evenement dans la bd
     * @param evenement
     */
    public void save(Evenement evenement) {
        evenementRepository.save(evenement);
    }
    /**
     * Cherche par id une Evenement
     * @param id du Evenement cherché
     * @return le Evenement cherché
     */
    public Evenement get(Long id) {
        return evenementRepository.findById(id).get();
    }
    /**
     * Supprime un Evenement par id
     * @param id de Evenement à supprimer
     */
    public void delete(Long id) {
        evenementRepository.deleteById(id);
    }

    public void addNewEvenement(Evenement evenement) {
        Optional<Evenement> billetOptional = evenementRepository.findEvenementById(evenement.getIdEvenement());
        if(billetOptional.isPresent()){
            throw new IllegalStateException("Evenement existe!");
        }
        evenementRepository.save(evenement);
    }

}
