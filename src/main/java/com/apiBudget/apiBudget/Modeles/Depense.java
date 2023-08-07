package com.apiBudget.apiBudget.Modeles;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.MERGE;

@Data
@Entity
@Table(name = "depense")
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

    public Depense() {

    }
}
