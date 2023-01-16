package com.example.eventnews.service;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.repository.AbonneRepository;
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
public class AbonneService {
    @Autowired
    private AbonneRepository abonneRepository;
    /**
     * Trouve la liste des Abonnes dans la bd.
     * @return la liste des Abonnes.
     */
    public List<Abonne> getAbonne() {
        return abonneRepository.findAll();
    }
    /**
     * Sauvegarde le Abonne dans la bd
     * @param abonne
     */
    public void save(Abonne abonne) {
        abonneRepository.save(abonne);
    }
    /**
     * Cherche par id un Abonne
     * @param id du Abonne cherché
     * @return le Abonne cherché
     */
    public Abonne get(Long id) {
        return abonneRepository.findById(id).get();
    }
    /**
     * Supprime un Abonne par id
     * @param id du produit à supprimer
     */
    public void delete(Long id) {
        abonneRepository.deleteById(id);
    }

    public void addNewAbonne(Abonne abonne) {
        Optional<Abonne> abonneOptional = abonneRepository.findAbonneByEmail(abonne.getCourriel());
        if(abonneOptional.isPresent()){
            throw new IllegalStateException("Abonné existe!");
        }
        abonneRepository.save(abonne);
    }


}
