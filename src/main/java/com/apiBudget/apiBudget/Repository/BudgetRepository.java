package com.apiBudget.apiBudget.Repository;

import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget,Long> {

    Budget findBudgetById(long id);

    Budget findByCategorie(Categorie budget);
}
