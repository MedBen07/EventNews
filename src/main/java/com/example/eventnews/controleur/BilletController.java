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

    @Autowired
    public BilletController(BilletService billetService) {
        this.billetService = billetService;
    }

    @GetMapping
    public List<Billet> getBillet(){
        return billetService.getBillet();
    }

    @PostMapping
    public void registrerNewAdresse(@RequestBody Billet billet){
        billetService.addNewBillet(billet);
    }
}
