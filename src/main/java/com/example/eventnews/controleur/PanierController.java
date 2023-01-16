package com.example.eventnews.controleur;

import com.example.eventnews.model.Panier;
import com.example.eventnews.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/panier")
public class PanierController {

    private final PanierService panierService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping
    public List<Panier> getPanier(){
        return panierService.getPanier();
    }

    @PostMapping
    public void EnregistrerNewPanier(@RequestBody Panier panier){
        panierService.addNewPanier(panier);
    }

}