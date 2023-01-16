package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Adresse;
import com.example.eventnews.repository.AbonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AbonneTests {

    @Autowired // SPRING BOOT VA INJECTER L'OBJET DANS abonneRepository QUI IMPLIMENTE L'INTERFACE AbonneRepository
    // INJECTION DE DEPENDANCE
    private AbonneRepository abonneRepository;


    @Test
    public void testCreateAbonne(){
        Abonne abonne1 = new Abonne("Jean", "Paul", "jean@gmail.com", "455-555-8888");
        abonneRepository.save(abonne1);
        Abonne abonne2 = new Abonne("Alex", "Dupon", "alex@gmail.com", "455-444-9999");
        abonneRepository.save(abonne2);
        Abonne abonne3 = new Abonne("Abdel", "Ali", "abdel@gmail.com", "455-444-9999");
        abonneRepository.save(abonne3);
        Abonne abonne4 = new Abonne("Julie", "Sarra", "julie@gmail.com", "455-444-9999");
        abonneRepository.save(abonne4);
        Abonne abonne5 = new Abonne("Nicole", "Gamache", "nicole@gmail.com", "455-444-9999");
        abonneRepository.save(abonne5);
    }

    @Test
    public void testFindAbonne(){
        Abonne abonne = abonneRepository.findById(2L).get();
        System.out.println(abonne.getCourriel()+"  "+ abonne.getNom()+"   "+ abonne.getPrenonm());

    }

    @Test
    public void testUpdateAbonne(){
        Abonne abonne = abonneRepository.findById(3L).get();
        abonne.setNom("Ali");
        abonneRepository.save(abonne);
        System.out.println("  "+ abonne.getNom() + "  ");
    }

    @Test
    public void testDeleteAbonne(){
        abonneRepository.deleteById(5L);
    }

    @Test
    public void testFindAllAbonnes(){
        List<Abonne> abonnes = abonneRepository.findAll();
        for(Abonne abonne : abonnes){
            System.out.println("   "+abonne.getNom()+ "   "+abonne.getPrenonm()+ "   ");
        }
    }
}
