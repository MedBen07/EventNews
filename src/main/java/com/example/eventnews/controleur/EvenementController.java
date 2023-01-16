package com.example.eventnews.controleur;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.model.Evenement;
import com.example.eventnews.service.AbonneService;
import com.example.eventnews.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/evennement")
public class EvenementController {

    private final EvenementService evenementService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping
    public List<Evenement> getEvenement(){
        return evenementService.getEvenement();
    }

    @PostMapping
    public void EnregistrerNewEvenement(@RequestBody Evenement evenement){
        evenementService.addNewEvenement(evenement);
    }
}
