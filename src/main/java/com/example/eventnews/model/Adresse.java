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
public class Adresse {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long idAdresse;
    private Integer numRue;
    private Integer appartement;
    private String rue;
    private String ville;
    private String province;
    private String codePostale;
    private String pays;

    @OneToMany(targetEntity = Adresse.class, cascade = CascadeType.ALL )
    private Set<Abonne> listeAbonnes;

    @OneToMany(targetEntity = Adresse.class, cascade = CascadeType.ALL )
    private Set<Visiteur> listeVisiteurs;

    public Adresse(Integer numRue, Integer appartement, String rue, String ville, String province, String codePostale,
                   String pays, Set<Abonne> listeAbonnes, Set<Visiteur> listeVisiteurs) {
        this.numRue = numRue;
        this.appartement = appartement;
        this.rue = rue;
        this.ville = ville;
        this.province = province;
        this.codePostale = codePostale;
        this.pays = pays;
        this.listeAbonnes = listeAbonnes;
        this.listeVisiteurs = listeVisiteurs;
    }

    public Adresse(Integer numRue, Integer appartement, String rue, String ville, String province, String codePostale,
                   String pays) {
        this.numRue = numRue;
        this.appartement = appartement;
        this.rue = rue;
        this.ville = ville;
        this.province = province;
        this.codePostale = codePostale;
        this.pays = pays;
    }
}
