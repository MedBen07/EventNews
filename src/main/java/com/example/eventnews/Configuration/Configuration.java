package com.example.eventnews.Configuration;

import com.example.eventnews.model.Abonne;
import com.example.eventnews.repository.AbonneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    CommandLineRunner commandLineRunner(AbonneRepository repository){
        return args -> {
            Abonne maryam = new Abonne(
                    "Maryam",
                    "Ben Ali",
                    "maryam@gmail.com",
                    "5141234567"
            );
            Abonne alex = new Abonne(

                    "Alex",
                    "Dubuison",
                    "alex@gmail.com",
                    "4305122211"
            );
//            repository.saveAll(
//                    List.of(maryam, alex)           );
        };
    }
}
