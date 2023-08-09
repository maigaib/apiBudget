package com.apiBudget.apiBudget.Modeles;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

   @OneToMany(mappedBy = "categorie")
   private List<Budget> budgets;

    //=========Reception de la cle primaire de l'utilisateur=======
    @ManyToOne
    @JsonIgnoreProperties(value = {"types","alertes","categories"})
    private Utilisateur utilisateur;

}
