package com.apiBudget.apiBudget.Modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    public static String getEmail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

//==========Envoie de la cle primaire dans la table Alerte=========
    @OneToMany(mappedBy = "utilisateur")
    private List<Alerte> alertes;

//==========Envoie de la cle primaire dans la table Alerte=========
    @OneToMany(mappedBy = "utilisateur")
    private List<Categorie> categories;
   //  ================Evoie de la cle primaire dans type========
    @OneToMany(mappedBy = "utilisateur")
    private List<Type> types;


}
