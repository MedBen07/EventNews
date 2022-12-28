package com.example.eventnews.controllerTests;

import com.example.eventnews.model.SystemAuthentification;
import com.example.eventnews.repository.PanierRepository;
import com.example.eventnews.repository.SystemAuthentificationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SystemAuthentificationTests {

    @Autowired
    // SPRING BOOT VA INJECTER L'OBJET DANS systemAuthentificationRepository QUI IMPLIMENTE L'INTERFACE
    // SystemAuthentificationRepository
    // INJECTION DE DEPENDANCE
    private SystemAuthentificationRepository systemAuthentificationRepository;
    @Test
    public void testCreateSystemAuthentification(){
        SystemAuthentification sysAuth1 = new SystemAuthentification("alex.f@gmail.com", "123456");
        systemAuthentificationRepository.save(sysAuth1);
        SystemAuthentification sysAuth2 = new SystemAuthentification("james_sam@gmail.com", "abcd1234");
        systemAuthentificationRepository.save(sysAuth2);
    }

    @Test
    public void testFindSystemAuthentification(){
        SystemAuthentification sysAuth = systemAuthentificationRepository.findById(2L).get();
        System.out.println("====== Id: " + sysAuth.getIdAuthentification()+" | Courriel: "+ sysAuth.getCourriel()+" | Mot de passe: "+ sysAuth.getPassword());
    }


}
