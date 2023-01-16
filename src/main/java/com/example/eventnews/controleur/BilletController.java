package com.example.eventnews.controleur;

import com.example.eventnews.model.Adresse;
import com.example.eventnews.model.Billet;
import com.example.eventnews.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/billet")
public class BilletController {
    private final BilletService billetService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public BilletController(BilletService billetService) {
        this.billetService = billetService;
    }

    @GetMapping
    public List<Billet> getBillet(){
        return billetService.getBillet();
    }

    @PostMapping
    public void EnregistrerNewAdresse(@RequestBody Billet billet){
        billetService.addNewBillet(billet);
    }
}
