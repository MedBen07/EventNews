package com.example.eventnews.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String descriptionCategorie;

    @OneToMany(targetEntity = Categorie.class, cascade = CascadeType.ALL )
    private Set<Evenement> listeEvenementsCategorie;

    public Categorie(String descriptionCategorie, Set<Evenement> listeEvenementsCategorie) {
        this.descriptionCategorie = descriptionCategorie;
        this.listeEvenementsCategorie = listeEvenementsCategorie;
    }

    public Categorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }
}
