package com.apiBudget.apiBudget.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private double budgetRestant = montantMax;

    @Column(nullable = false)
    private Date date;
    // ================Reception de la cle primaire de la categorie=======
    @ManyToOne
    @JsonIgnoreProperties(value = {"budgets","alertes"})
    private Categorie categorie;
    // ================Envoie de la cle primaire dans depense=======
    @OneToMany(mappedBy = "budget")
    private List<Depense> depenses;
    // ================Envoie de la cle primaire dans alerte=======
    @OneToMany(mappedBy = "budget")
    private  List<Alerte> alertes;

}
