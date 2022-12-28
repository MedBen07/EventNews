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
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;
    private Double tauxTPS = 5.0;
    private Double tauxTVQ= 9.975;

    @OneToMany(targetEntity = Billet.class, cascade = CascadeType.ALL)
    private Set<Billet> billetList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAbonne_fk")
    private Abonne abonne;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVisiteur_fk")
    private Visiteur visiteur;

    public Panier(Double tauxTPS, Double tauxTVQ, Set<Billet> billetList, Abonne abonne, Visiteur visiteur) {
        this.tauxTPS = tauxTPS;
        this.tauxTVQ = tauxTVQ;
        this.billetList = billetList;
        this.abonne = abonne;
        this.visiteur = visiteur;
    }

}
