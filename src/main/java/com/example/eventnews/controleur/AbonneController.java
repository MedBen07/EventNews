package com.example.eventnews.controleur;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.service.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/abonne")
public class AbonneController {
    private final AbonneService abonneService;
/**
 * Il faudra injecter un lien vers la classe Service ainsi.
 * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
 * */
    @Autowired
    public AbonneController(AbonneService abonneService) {
        this.abonneService = abonneService;
    }

    @GetMapping
    public List<Abonne> getAbonne(){
        return abonneService.getAbonne();
    }

    @PostMapping
    public void EnregistrerNewAbonne(@RequestBody Abonne abonne){
        abonneService.addNewAbonne(abonne);
    }


}
