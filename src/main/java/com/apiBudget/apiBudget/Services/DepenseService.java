package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Repository.BudgetRepository;
import com.apiBudget.apiBudget.Repository.DepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepenseService {
    @Autowired
    private DepenseRepository depenseRepository;

    @Autowired
    private BudgetRepository budgetRepository;
    public List<Depense> getAllDepensesForSpecificBudget(Long budgetId){
        return depenseRepository.findByBudgetBudgetId(budgetId);
    }

    public Depense addDepense(Depense depense, Long budgetId) {
        Budget budget = budgetRepository.findByBudgetBudgetId(budgetId);
            depense.setBudget(budget);
            return depenseRepository.save(depense);
    }

    public boolean deleteDepenseById(Long depenseId){
        depenseRepository.deleteById(depenseId);
        return true;
    }


}
