package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Visiteur;
import com.example.eventnews.repository.SystemAuthentificationRepository;
import com.example.eventnews.repository.VisiteurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VisiteurTests {

    @Autowired
    // SPRING BOOT VA INJECTER L'OBJET DANS visiteurRepository QUI IMPLIMENTE L'INTERFACE
    // VisiteurRepository
    // INJECTION DE DEPENDANCE
    private VisiteurRepository visiteurRepository;
    @Test
    public void testCreateVisiteur(){
        Visiteur visiteur1 = new Visiteur("karim", "salmi", "sk@gmail.com", "435 888 4567");
        visiteurRepository.save(visiteur1);
        Visiteur visiteur2 = new Visiteur("madi", "alex", "ma@gmail.com", "514 222 9999");
        visiteurRepository.save(visiteur2);
    }

    @Test
    public void testFindVisiteur(){
        Visiteur visiteur = visiteurRepository.findById(2L).get();
        System.out.println("===== Nom: " + visiteur.getNom()+" | Prenom: "+ visiteur.getPrenom()+" | Courriel: "+ visiteur.getCourriel());
    }
}
