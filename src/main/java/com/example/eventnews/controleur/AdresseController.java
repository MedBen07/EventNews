package com.example.eventnews.controleur;

import com.example.eventnews.model.Adresse;
import com.example.eventnews.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/adresse")
public class AdresseController {
    private final AdresseService adresseService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping
    public List<Adresse> getAdresse(){
        return adresseService.getAdresse();
    }

    @PostMapping
    public void EnregistrerNewAdresse(@RequestBody Adresse adresse){
        adresseService.addNewAdresse(adresse);
    }
}
