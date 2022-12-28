package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Billet;
import com.example.eventnews.repository.BilletRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class BilletTests {

    @Autowired // SPRING BOOT VA INJECTER L'OBJET DANS billetRepository QUI IMPLIMENTE L'INTERFACE
    // BilletRepository  ====  INJECTION DE DEPENDANCE
    private BilletRepository billetRepository;
    @Test
    public void testCreateBillet(){
        Billet billet1 = new Billet(LocalDateTime.of(2022,06,07,18,15,22), 2);
        billetRepository.save(billet1);
        Billet billet2 = new Billet(LocalDateTime.of(2022,06,10,14,50,45),3);
        billetRepository.save(billet2);
    }

    @Test
    public void testFindBillet(){
        Billet billet = billetRepository.findById(2L).get();
        System.out.println("============== Id Billet: " + billet.getIdBillet()+" |  Nombre de Billet: "+ billet.getNbreBillet()+" |  Date d'Achat: "+ billet.getDateAchat()+" ==================");
    }
}
