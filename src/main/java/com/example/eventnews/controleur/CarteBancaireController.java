package com.example.eventnews.controleur;

import com.example.eventnews.model.CarteBancaire;
import com.example.eventnews.service.CarteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="/carte")
public class CarteBancaireController {
    private final CarteBancaireService carteBancaireService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public CarteBancaireController(CarteBancaireService carteBancaireService) {
        this.carteBancaireService = carteBancaireService;
    }

    @GetMapping
    public List<CarteBancaire> CarteBancaire(){
        return carteBancaireService.getCarteBancaire();
    }

    @PostMapping
    public void EnregistrerNewAdresse(@RequestBody CarteBancaire carteBancaire){
        carteBancaireService.addNewCarteBancaire(carteBancaire);
    }
}
