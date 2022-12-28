package com.example.eventnews.controleur;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Categorie;
import com.example.eventnews.service.AbonneService;
import com.example.eventnews.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/categorie")
public class CategorieController {

    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getCategorie(){
        return categorieService.getCategorie();
    }

    @PostMapping
    public void registrerNewCategorie(@RequestBody Categorie abonne){
        categorieService.addNewCategorie(abonne);
    }
}
