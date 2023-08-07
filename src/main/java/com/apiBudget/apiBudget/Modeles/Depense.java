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
    private Long id ;

    @NonNull
    private String description;

    @NonNull
    private Integer montant ;


    private LocalDate date = LocalDate.now();


    @ManyToOne (cascade = {CascadeType.PERSIST, MERGE})
    private Type type;

    @ManyToOne(cascade = {CascadeType.PERSIST, MERGE })
    private Budget budget;
}
