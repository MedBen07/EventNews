package com.example.eventnews.controleur;

import com.example.eventnews.model.Panier;
import com.example.eventnews.model.Visiteur;
import com.example.eventnews.service.PanierService;
import com.example.eventnews.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/visiteur")
public class VisiteurController {

    private final VisiteurService visiteurService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public VisiteurController(VisiteurService visiteurService) {
        this.visiteurService = visiteurService;
    }

    @GetMapping
    public List<Visiteur> getVisiteur(){
        return visiteurService.getVisiteur();
    }

    @PostMapping
    public void EnregistrerNewPanier(@RequestBody Visiteur visiteur){
        visiteurService.addNewVisiteur(visiteur);
    }
}
