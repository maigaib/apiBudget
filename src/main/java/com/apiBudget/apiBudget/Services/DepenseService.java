package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Repository.BudgetRepository;
import com.apiBudget.apiBudget.Repository.DepenseRepository;
import com.apiBudget.apiBudget.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepenseService {
    @Autowired
    private DepenseRepository depenseRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    public List<Depense> getAllDepensesForSpecificBudget(Long id){

        return depenseRepository.findDepensesByBudgetId(id);
    }

    public Depense addDepense(Depense depense) {
        //=================Obtenir le budget a travers son id ================

        Budget budget = budgetRepository.findBudgetById(depense.getBudget().getId());

        //=================Verifie si le budget existe dans la base ================

        if (budget==null)
            throw new RuntimeException("Le budget correspondant n'existe pas.");
        return depenseRepository.save(depense);

    }

    public Depense updateDepense(Depense depense, Long id) {
        Depense exDepense = depenseRepository.findById(id).orElse(null);
        if (exDepense == null) {
            throw new RuntimeException("La depense correspondant n'existe pas.");
        }else {
        exDepense.setMontant(depense.getMontant());
        exDepense.setDescription(depense.getDescription());
        exDepense.setDate(depense.getDate());
        return depenseRepository.save(exDepense);}
    }

    public boolean deleteDepenseById(Long id){
        depenseRepository.deleteById(id);
        return true;
    }


}
