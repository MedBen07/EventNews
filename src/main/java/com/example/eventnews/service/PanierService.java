package com.example.eventnews.service;

import com.example.eventnews.model.Panier;
import com.example.eventnews.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;
    /**
     * Trouve la liste des Panier dans la bd.
     * @return la liste des Panier.
     */
    public List<Panier> getPanier() {
        return panierRepository.findAll();
    }
    /**
     * Sauvegarde le Panier dans la bd
     * @param panier
     */
    public void save(Panier panier) {
        panierRepository.save(panier);
    }
    /**
     * Cherche par id une Panier
     * @param id du Panier cherché
     * @return le Panier cherché
     */
    public Panier get(Long id) {
        return panierRepository.findById(id).get();
    }
    /**
     * Supprime un Panier par id
     * @param id de Panier à supprimer
     */
    public void delete(Long id) {
        panierRepository.deleteById(id);
    }

    public void addNewPanier(Panier panier) {
        Optional<Panier> billetOptional = panierRepository.findPanierById(panier.getIdPanier());
        if(billetOptional.isPresent()){
            throw new IllegalStateException("Panier existe!");
        }
        panierRepository.save(panier);
    }
}
