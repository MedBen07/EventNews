package com.example.eventnews.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class CarteBancaire {
    @Id
    private Long numCarte;
    private LocalDate dateExpiration;
    private Integer codeCVV;
    private String typeCarte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAbonne_fk")
    private Abonne abonne;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVisiteur_fk")
    private Visiteur visiteur;

    public CarteBancaire(Long numCarte, LocalDate dateExpiration, Integer codeCVV, String typeCarte) {
        this.numCarte = numCarte;
        this.dateExpiration = dateExpiration;
        this.codeCVV = codeCVV;
        this.typeCarte = typeCarte;
    }

}
