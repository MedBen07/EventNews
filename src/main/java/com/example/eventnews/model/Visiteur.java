package com.example.eventnews.model;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Visiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisiteur;
    private String nom;
    private String prenom;
    private String courriel;
    private String telephone;

    @JoinColumn(name= "idAdresse_fk", referencedColumnName = "idAdresse")
    @ManyToOne()
    private Adresse adresse;

    public Visiteur(String nom, String prenom, String courriel, String telephone, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Visiteur(String nom, String prenom, String courriel, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
    }
}
