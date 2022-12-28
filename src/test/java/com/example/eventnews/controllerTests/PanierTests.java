package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Panier;
import com.example.eventnews.repository.EvenementRepository;
import com.example.eventnews.repository.PanierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PanierTests {

    @Autowired
    // SPRING BOOT VA INJECTER L'OBJET DANS panierRepository QUI IMPLIMENTE L'INTERFACE
    // PanierRepository
    // INJECTION DE DEPENDANCE
    private PanierRepository panierRepository;
    @Test
    public void testCreatePanier(){
        Panier panier1 = new Panier();
        panierRepository.save(panier1);
    }

    @Test
    public void testFindPanier(){
        Panier panier = panierRepository.findById(1L).get();
        System.out.println("====== Id: " + panier.getIdPanier()+" | TPS: "+ panier.getTauxTPS()+" | TVQ: "+ panier.getTauxTVQ());
    }
}
