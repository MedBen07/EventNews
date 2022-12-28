package com.example.eventnews.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;
    private String titreEvenement;
    private String descriptionEvenement;
    private Double prix;
    private Integer nbrePlaces;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String lieuEvenement;
    private Integer placesRestantes;
    private String lienImage;
    private String etatEvenement;

    @JoinColumn(name = "idCategorie_fk", referencedColumnName = "idCategorie")
    @ManyToOne()
    private Categorie categorie;

    @JoinColumn(name = "idAbonne_fk", referencedColumnName = "idAbonne")
    @ManyToOne()
    private Abonne abonne;

    public Evenement(String titreEvenement, String descriptionEvenement, Double prix, Integer nbrePlaces,
                     LocalDateTime dateDebut, LocalDateTime dateFin, String lieuEvenement, Integer placesRestantes,
                     String lienImage, String etatEvenement) {
        this.titreEvenement = titreEvenement;
        this.descriptionEvenement = descriptionEvenement;
        this.prix = prix;
        this.nbrePlaces = nbrePlaces;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieuEvenement = lieuEvenement;
        this.placesRestantes = placesRestantes;
        this.lienImage = lienImage;
        this.etatEvenement = etatEvenement;
    }
}
