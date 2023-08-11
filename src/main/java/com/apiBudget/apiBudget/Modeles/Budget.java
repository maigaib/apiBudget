package com.apiBudget.apiBudget.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double montantMax;

    @Column(nullable = false)
    private double montantAlert;
    //=====================declaration de la date de debut===============



    @Column(nullable = false)
    private LocalDate dateDebut;


    //=====================declaration de la date de fin===============

    private  LocalDate dateFin ;


    //@Column(nullable = false)
    private double budgetRestant ;

    // ================Reception de la cle primaire de la categorie=======
    @ManyToOne
    @JsonIgnoreProperties(value = {"budgets","alertes"})
    private Categorie categorie;
    // ================Envoie de la cle primaire dans depense=======
    @OneToMany(mappedBy = "budget")
    @JsonIgnore
    private List<Depense> depenses;
    // ================Envoie de la cle primaire dans alerte=======
    @OneToMany(mappedBy = "budget")
    @JsonIgnore
    private  List<Alerte> alertes;

}
