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

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping
    public List<Adresse> getAdresse(){
        return adresseService.getAdresse();
    }

    @PostMapping
    public void registrerNewAdresse(@RequestBody Adresse adresse){
        adresseService.addNewAdresse(adresse);
    }
}
