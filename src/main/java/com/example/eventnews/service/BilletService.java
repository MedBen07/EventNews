package com.example.eventnews.service;

import com.example.eventnews.model.Adresse;
import com.example.eventnews.model.Billet;
import com.example.eventnews.repository.AdresseRepository;
import com.example.eventnews.repository.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BilletService {
    @Autowired
    private BilletRepository billetRepository;
    /**
     * Trouve la liste des Billets dans la bd.
     * @return la liste des Billets.
     */
    public List<Billet> getBillet() {
        return billetRepository.findAll();
    }
    /**
     * Sauvegarde le Billet dans la bd
     * @param billet
     */
    public void save(Billet billet) {
        billetRepository.save(billet);
    }
    /**
     * Cherche par id une Adresse
     * @param id du Billet cherché
     * @return le Billet cherché
     */
    public Billet get(Long id) {
        return billetRepository.findById(id).get();
    }
    /**
     * Supprime un Billet par id
     * @param id de Billet à supprimer
     */
    public void delete(Long id) {
        billetRepository.deleteById(id);
    }

    public void addNewBillet(Billet billet) {
        Optional<Billet> billetOptional = billetRepository.findBilletById(billet.getIdBillet());
        if(billetOptional.isPresent()){
            throw new IllegalStateException("Billet existe!");
        }
        billetRepository.save(billet);
    }
}
