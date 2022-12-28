package com.example.eventnews.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBillet;
    private LocalDateTime dateAchat;
    private Integer nbreBillet;

    @JoinColumn(name= "idPanier_fk", referencedColumnName = "idPanier")
    @ManyToOne()
    private Panier panier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEvenement_fk")
    private Evenement evenement;

    public Billet(LocalDateTime dateAchat, Integer nbreBillet) {
        this.dateAchat = dateAchat;
        this.nbreBillet = nbreBillet;
    }

    public Billet(LocalDateTime dateAchat, Integer nbreBillet, Panier panier, Evenement evenement) {
        this.dateAchat = dateAchat;
        this.nbreBillet = nbreBillet;
        this.panier = panier;
        this.evenement = evenement;
    }
}
