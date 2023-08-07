package com.apiBudget.apiBudget.Modeles;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.model.internal.BinderHelper;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
@NoArgsConstructor
@Data
public class Type {
    //============Id du type==============
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //=========== Nom du type=================
    @Column(nullable = false, length = 50)
    private String nom;
    // =========== la cle etrangere Utilisateur ===========
    @ManyToOne
    private Utilisateur utilisateur;
    //============Envoi de la cle etrangere dans depense========
    @OneToMany (mappedBy = "type",cascade = CascadeType.ALL)
    private List<Depense> depenses;

    //
}
