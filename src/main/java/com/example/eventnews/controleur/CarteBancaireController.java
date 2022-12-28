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

    @Autowired
    public CarteBancaireController(CarteBancaireService carteBancaireService) {
        this.carteBancaireService = carteBancaireService;
    }

    @GetMapping
    public List<CarteBancaire> CarteBancaire(){
        return carteBancaireService.getCarteBancaire();
    }

    @PostMapping
    public void registrerNewAdresse(@RequestBody CarteBancaire carteBancaire){
        carteBancaireService.addNewCarteBancaire(carteBancaire);
    }
}
