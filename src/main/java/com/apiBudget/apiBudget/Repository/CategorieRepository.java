package com.apiBudget.apiBudget.Repository;

import com.apiBudget.apiBudget.Modeles.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    //Categorie findCategorieById(Long id);

    Categorie findByLibelle(String libelle);
}
