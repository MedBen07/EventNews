package com.example.eventnews.service;

import com.example.eventnews.model.Visiteur;
import com.example.eventnews.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VisiteurService {
    @Autowired
    private VisiteurRepository visiteurRepository;
    /**
     * Trouve la liste des Visiteurs dans la bd.
     * @return la liste des Visiteurs.
     */
    public List<Visiteur> getVisiteur() {
        return visiteurRepository.findAll();
    }
    /**
     * Sauvegarde le visiteur dans la bd
     * @param visiteur
     */
    public void save(Visiteur visiteur) {
        visiteurRepository.save(visiteur);
    }
    /**
     * Cherche par id Visiteur
     * @param id du Visiteur cherché
     * @return le Visiteur cherché
     */
    public Visiteur get(Long id) {
        return visiteurRepository.findById(id).get();
    }
    /**
     * Supprime un Visiteur par id
     * @param id de Visiteur à supprimer
     */
    public void delete(Long id) {
        visiteurRepository.deleteById(id);
    }

    public void addNewVisiteur(Visiteur visiteur) {
        Optional<Visiteur> visiteurOptional = visiteurRepository.findVisiteurById(visiteur.getIdVisiteur());
        if(visiteurOptional.isPresent()){
            throw new IllegalStateException("Visiteur existe!");
        }
        visiteurRepository.save(visiteur);
    }
}
