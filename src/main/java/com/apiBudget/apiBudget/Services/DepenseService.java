package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Repository.BudgetRepository;
import com.apiBudget.apiBudget.Repository.DepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepenseService {
    @Autowired
    private DepenseRepository depenseRepository;

    @Autowired
    private BudgetRepository budgetRepository;
    public List<Depense> getAllDepensesForSpecificBudget(Long budgetId){
        return depenseRepository.findDepenseByBudgetId(budgetId);
    }

    public Depense addDepense(Depense depense, Long id) {
        //=========Obtenir de budget a traver son  id===============
        Optional<Budget> budget = budgetRepository.findById(id);
        //========verifier si le budget est dans le basse=======
            depense.setBudget(budget.get());

            return depenseRepository.save(depense);
    }

    public Depense updateDepense(Depense depense, Long id) {
        Depense exDepense = depenseRepository.findById(id).orElse(null);
        if (exDepense == null) {
            return null;
        }else {
        exDepense.setMontant(depense.getMontant());
        exDepense.setDescription(depense.getDescription());
        exDepense.setDate(depense.getDate());
        return depenseRepository.save(exDepense);}
    }

    public boolean deleteDepenseById(Long depenseId){
        depenseRepository.deleteById(depenseId);
        return true;
    }


}
