package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Evenement;
import com.example.eventnews.repository.CategorieRepository;
import com.example.eventnews.repository.EvenementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
public class EvenementTests {

    @Autowired
    // SPRING BOOT VA INJECTER L'OBJET DANS evenementRepository QUI IMPLIMENTE L'INTERFACE
    // EvenementRepository
    // INJECTION DE DEPENDANCE
    private EvenementRepository evenementRepository;
    @Test
    public void testCreateEvenement(){
        Evenement evenement1 = new Evenement("Randonnée 2022", "Randonnée spéciale enfant",
                20.50,20, LocalDateTime.of(2022, Month.DECEMBER, 15,10,00,00),
                LocalDateTime.of(2022,12,15,15,00,00),"Mont-Royale",
                20, ".//resources/static/image/ph1.jpg", "Disponible");
        evenementRepository.save(evenement1);
        Evenement evenement2 = new Evenement("Match de football", "amecale pour junior",
                10.50,30, LocalDateTime.of(2022, Month.DECEMBER, 13,14,00,00),
                LocalDateTime.of(2022,12,13,17,00,00),"village-olympique",
                30, ".//resources/static/image/ph2.jpg", "Disponible");
        evenementRepository.save(evenement2);
    }

    @Test
    public void testFindEvenement(){
        Evenement evenement = evenementRepository.findById(2L).get();
        System.out.println(evenement);
    }
}
