package com.apiBudget.apiBudget.Modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Alerte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alerte {
    //==================Cle primaire Alerte==========
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //==================Message d'alerte==========
    @Column(nullable = false)
    private String message;

    //==================Date alerte==========
    @Column(nullable = false)
    private Date date;

    //==================Vue d'alerte par l'utilisateur==========
    @Column(nullable = false)
    private boolean vue;

    //=========Reception de la cle primaire de l'utilisateur=======
    @ManyToOne
    private Utilisateur utilisateur;


}
