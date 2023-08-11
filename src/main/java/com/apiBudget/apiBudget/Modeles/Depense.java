package com.apiBudget.apiBudget.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.CascadeType.MERGE;


@Entity
@Table(name = "depense")
@Getter
@Setter

public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NonNull
    private String description;

    @NonNull
    private Integer montant ;

    private LocalDate date;


    @ManyToOne
    @JsonIgnoreProperties(value = {"depenses"})
    private Type type;

    //=========Reception de la cle primaire du budget=======

    @ManyToOne
    @JsonIgnoreProperties(value = {"depenses","alertes"})
    private Budget budget;

}
