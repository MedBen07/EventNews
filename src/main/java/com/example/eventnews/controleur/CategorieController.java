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
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> getCategorie(){
        return categorieService.getCategorie();
    }

    @PostMapping
    public void EnregistrerNewCategorie(@RequestBody Categorie abonne){
        categorieService.addNewCategorie(abonne);
    }
}
