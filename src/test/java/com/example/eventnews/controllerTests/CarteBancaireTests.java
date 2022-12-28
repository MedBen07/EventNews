package com.example.eventnews.controllerTests;

import com.example.eventnews.model.CarteBancaire;
import com.example.eventnews.repository.BilletRepository;
import com.example.eventnews.repository.CarteBancaireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class CarteBancaireTests {

    @Autowired
    // SPRING BOOT VA INJECTER L'OBJET DANS carteBancaireRepository QUI IMPLIMENTE L'INTERFACE
    // CarteBancaireRepository
    // INJECTION DE DEPENDANCE
    private CarteBancaireRepository carteBancaireRepository;
    @Test
    public void testCreateSystemAuthentification(){
        CarteBancaire carteBancaire1 = new CarteBancaire(1111222233334444L, LocalDate.of(2023, Month.DECEMBER,18),445, "visa");
        carteBancaireRepository.save(carteBancaire1);
        CarteBancaire carteBancaire2 = new CarteBancaire(4444555566667777L, LocalDate.of(2024, Month.JANUARY, 10), 754, "Master");
        carteBancaireRepository.save(carteBancaire2);
    }

    @Test
    public void testFindCarteBancaire(){
        CarteBancaire carteBancaire = carteBancaireRepository.findById(1111222233334444L).get();
        System.out.println("numéro de carte : " + carteBancaire.getNumCarte()+" | Code: "+ carteBancaire.getCodeCVV()+" | Type: "+ carteBancaire.getTypeCarte());
    }
}
