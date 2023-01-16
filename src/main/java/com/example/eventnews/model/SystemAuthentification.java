package com.example.eventnews.model;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class SystemAuthentification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthentification;
    private String courriel;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAbonne_fk")
    private Abonne abonne;

    public SystemAuthentification(String courriel, String password, Abonne abonne) {
        this.courriel = courriel;
        this.password = password;
        this.abonne = abonne;
    }

    public SystemAuthentification(String courriel, String password) {
        this.courriel = courriel;
        this.password = password;
    }
}
