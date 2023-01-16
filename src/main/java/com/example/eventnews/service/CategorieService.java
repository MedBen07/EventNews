package com.example.eventnews.service;

import com.example.eventnews.model.Categorie;
import com.example.eventnews.repository.CategorieRepository;
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
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;
    /**
     * Trouve la liste des Categorie dans la bd.
     * @return la liste des Categorie.
     */
    public List<Categorie> getCategorie() {
        return categorieRepository.findAll();
    }
    /**
     * Sauvegarde le Categorie dans la bd
     * @param categorie
     */
    public void save(Categorie categorie) {
        categorieRepository.save(categorie);
    }
    /**
     * Cherche par id une Categorie
     * @param id du Categorie cherché
     * @return le Categorie cherché
     */
    public Categorie get(Long id) {
        return categorieRepository.findById(id).get();
    }
    /**
     * Supprime un Categorie par id
     * @param id de Categorie à supprimer
     */
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }

    public void addNewCategorie(Categorie categorie) {
        Optional<Categorie> billetOptional = categorieRepository.findCategorieById(categorie.getIdCategorie());
        if(billetOptional.isPresent()){
            throw new IllegalStateException("Categorie existe!");
        }
        categorieRepository.save(categorie);
    }
}
