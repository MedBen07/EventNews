package com.example.eventnews.controleur;

import com.example.eventnews.model.Panier;
import com.example.eventnews.model.SystemAuthentification;
import com.example.eventnews.service.PanierService;
import com.example.eventnews.service.SystemAuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/authentification")
public class SystemAuthentificationController {

    private final SystemAuthentificationService systemAuthentificationService;
    /**
     * Il faudra injecter un lien vers la classe Service ainsi.
     * En utilisant le tag @Autowired. On n’a pas besoin d’instancier l’objet via le constructeur.
     * */
    @Autowired
    public SystemAuthentificationController(SystemAuthentificationService systemAuthentificationService) {
        this.systemAuthentificationService = systemAuthentificationService;
    }

    @GetMapping
    public List<SystemAuthentification> getPanier(){
        return systemAuthentificationService.getSystemAuthentification();
    }

    @PostMapping
    public void EnregistrerNewSystemAuthentification(@RequestBody SystemAuthentification systemAuthentification){
        systemAuthentificationService.addNewSystemAuthentification(systemAuthentification);
    }
}
