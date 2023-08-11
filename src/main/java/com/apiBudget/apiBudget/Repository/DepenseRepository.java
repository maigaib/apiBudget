package com.apiBudget.apiBudget.Repository;

import com.apiBudget.apiBudget.Modeles.Depense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {

    List<Depense> findByBudgetId(Long id);
    List<Depense> findDepensesByBudgetId(Long id);
    List<Depense> findAll();
}

