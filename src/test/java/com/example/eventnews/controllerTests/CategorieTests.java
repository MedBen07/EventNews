package com.example.eventnews.controllerTests;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Categorie;
import com.example.eventnews.repository.CarteBancaireRepository;
import com.example.eventnews.repository.CategorieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategorieTests {

    @Autowired
    // SPRING BOOT VA INJECTER L'OBJET DANS categorieRepository QUI IMPLIMENTE L'INTERFACE
    // CategorieRepository
    // INJECTION DE DEPENDANCE
    private CategorieRepository categorieRepository;
    @Test
    public void testCreateCategorie(){
        Categorie categorie1 = new Categorie("musique");
        categorieRepository.save(categorie1);
        Categorie categorie2 = new Categorie("randonnée");
        categorieRepository.save(categorie2);
    }

    @Test
    public void testFindCategorie(){
        Categorie categorie = categorieRepository.findById(2L).get();
        System.out.println("============== Id Categorie: " +categorie.getIdCategorie()+" | Description: "+ categorie.getDescriptionCategorie());
    }


}


