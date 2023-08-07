package com.apiBudget.apiBudget.Repository;


import com.apiBudget.apiBudget.Modeles.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmail(String email);

}
