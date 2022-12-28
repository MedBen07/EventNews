package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Adresse;
import com.example.eventnews.repository.AbonneRepository;
import com.example.eventnews.repository.AdresseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdresseTests {

    @Autowired // SPRING BOOT VA INJECTER L'OBJET DANS adresseRepository QUI IMPLIMENTE L'INTERFACE AdresseRepository
    // INJECTION DE DEPENDANCE
    private AdresseRepository adresseRepository;

    @Test
    public void testCreateAdresse(){
        Adresse adresse1 = new Adresse(3320,5,"Saint-laurent", "Montréal", "Qc", "h5v5h1","CA");
        adresseRepository.save(adresse1);
        Adresse adresse2 = new Adresse(9011,2,"Vieux", "Montréal", "Qc", "h7j2m1","CA");
        adresseRepository.save(adresse2);
    }
}
