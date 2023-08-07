package com.apiBudget.apiBudget.Repository;

import com.apiBudget.apiBudget.Modeles.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
}
