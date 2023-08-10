package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Utilisateur;
import com.apiBudget.apiBudget.Repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;


    public Budget createBudget(Budget budget){
        return budgetRepository.save(budget);
    }
    public List<Budget> getAllBudget(){
        return budgetRepository.findAll();
    }

    public Optional<Budget> getBudgetById(Long id){
        return budgetRepository.findById(id);
    }

    public boolean deleteBudgetById(Long id){
        budgetRepository.deleteById(id);
        return true;
    }

    public Budget editBudget(Long id, Budget budget){
        Budget budget1 = budgetRepository.findById(id)
                .map(p ->{
                    p.setMontantMax(budget.getMontantMax());
                    p.setMontantAlert(budget.getMontantAlert());
                    p.setDateDebut(budget.getDateDebut());
                    p.setDateFin(budget.getDateFin());
                    return budgetRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Budget non trouvé"));
        return budget1;
    }

}
