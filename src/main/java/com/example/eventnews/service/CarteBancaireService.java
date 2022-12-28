package com.example.eventnews.service;

import com.example.eventnews.model.Billet;
import com.example.eventnews.model.CarteBancaire;
import com.example.eventnews.repository.BilletRepository;
import com.example.eventnews.repository.CarteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarteBancaireService {
    @Autowired
    private CarteBancaireRepository carteBancaireRepository;
    /**
     * Trouve la liste des carteBancaire dans la bd.
     * @return la liste des carteBancaire.
     */
    public List<CarteBancaire> getCarteBancaire() {
        return carteBancaireRepository.findAll();
    }
    /**
     * Sauvegarde le Billet dans la bd
     * @param carteBancaire
     */
    public void save(CarteBancaire carteBancaire) {
        carteBancaireRepository.save(carteBancaire);
    }
    /**
     * Cherche par id une Adresse
     * @param num_carte du CarteBancaire cherché
     * @return le CarteBancaire cherché
     */
    public CarteBancaire get(Long num_carte) {
        return carteBancaireRepository.findBilletByNumCarte(num_carte).get();
    }
    /**
     * Supprime un CarteBancaire par num_carte
     * @param num_carte de CarteBancaire à supprimer
     */
    public void delete(Long num_carte) {
        carteBancaireRepository.findBilletByNumCarte(num_carte);
    }

    public void addNewCarteBancaire(CarteBancaire carteBancaire) {
        Optional<CarteBancaire> carteBancaireOptional = carteBancaireRepository.findBilletByNumCarte(carteBancaire.getNumCarte());
        if(carteBancaireOptional.isPresent()){
            throw new IllegalStateException("Carte existe!");
        }
        carteBancaireRepository.save(carteBancaire);
    }
}
