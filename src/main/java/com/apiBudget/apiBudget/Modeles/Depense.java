package com.apiBudget.apiBudget.Modeles;

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
    @Column(name = "depenseId")
    private Long depenseId ;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "montantDepense")
    private Integer montant ;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();


    @ManyToOne (cascade = {CascadeType.PERSIST, MERGE})
    @JoinColumn(name = "Id")
    private Type type;

    @ManyToOne(cascade = {CascadeType.PERSIST, MERGE })
    @JoinColumn(name = "Id")
    private Budget budget;

}
