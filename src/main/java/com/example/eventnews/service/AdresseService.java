package com.example.eventnews.service;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Adresse;
import com.example.eventnews.repository.AbonneRepository;
import com.example.eventnews.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdresseService {
    @Autowired
    private AdresseRepository adresseRepository;
    /**
     * Trouve la liste des Adresses dans la bd.
     * @return la liste des Adresses.
     */
    public List<Adresse> getAdresse() {
        return adresseRepository.findAll();
    }
    /**
     * Sauvegarde le Abonne dans la bd
     * @param adresse
     */
    public void save(Adresse adresse) {
        adresseRepository.save(adresse);
    }
    /**
     * Cherche par id une Adresse
     * @param id du Adresse cherché
     * @return le Adresse cherché
     */
    public Adresse get(Long id) {
        return adresseRepository.findById(id).get();
    }
    /**
     * Supprime un Adresse par id
     * @param id de  l'Adresse à supprimer
     */
    public void delete(Long id) {
        adresseRepository.deleteById(id);
    }

    public void addNewAdresse(Adresse adresse) {
        Optional<Adresse> adresseOptional = adresseRepository.findAdresseById(adresse.getIdAdresse());
        if(adresseOptional.isPresent()){
            throw new IllegalStateException("Adresse existe!");
        }
        adresseRepository.save(adresse);
    }
}
