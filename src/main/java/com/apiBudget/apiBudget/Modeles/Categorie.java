package com.apiBudget.apiBudget.Modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

    //=================Cle primaire de categorie==========
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //==================Libelle categorie==========
    @Column(length = 100, nullable = false,unique = true)
    private String libelle;

//==========Envoie de la cle primaire dans la table Budget=========

   // Doucoure devrait se chargé de la mise en place de cette cle des deux côtés

    //=========Reception de la cle primaire de l'utilisateur=======
    @ManyToOne
    private Utilisateur utilisateur;
}
