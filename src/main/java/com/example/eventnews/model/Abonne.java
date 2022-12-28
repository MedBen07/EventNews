package com.example.eventnews.model;



import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Abonne {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long idAbonne;
    private String nom;
    private String prenonm;
    private String courriel;
    private String telephone;

    @OneToMany(targetEntity = Evenement.class, cascade = CascadeType.ALL )
    private Set<Evenement> listeEvenementsAbonne;

    @JoinColumn(name= "idAdresse_fk", referencedColumnName = "idAdresse")
    @ManyToOne()
    private Adresse adresse;

    public Abonne(String nom, String prenonm, String courriel, String telephone) {
        this.nom = nom;
        this.prenonm = prenonm;
        this.courriel = courriel;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Abonne(String nom, String prenonm, String courriel, String telephone,
                  Set<Evenement> listeEvenementsAbonne, Adresse adresse) {
        this.nom = nom;
        this.prenonm = prenonm;
        this.courriel = courriel;
        this.telephone = telephone;
        this.listeEvenementsAbonne = listeEvenementsAbonne;
        this.adresse = adresse;
    }
}
