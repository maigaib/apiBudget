package com.apiBudget.apiBudget.Modeles;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.util.Date;

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


    @OneToOne (cascade = {CascadeType.PERSIST, MERGE})
    @JoinColumn(name = "typeId")
    private Type type;

    @OneToOne(cascade = {CascadeType.PERSIST, MERGE })
    @JoinColumn(name = "budgetId")
    private Budget budget;
}
