package com.apiBudget.apiBudget.Controller;


import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Utilisateur;
import com.apiBudget.apiBudget.Services.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("budget")
@RestController
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/{id}")
    public Budget getUseById(@PathVariable Long id){
        Optional<Budget> user = budgetService.getBudgetById(id);
        return (Budget) user.orElse(null);
    }
    @PutMapping("/update/{id}")
    public Optional<Budget> updateUtilisateur(@PathVariable Long id,@RequestBody Budget budget){
        Optional<Budget> budget1 = Optional.ofNullable(budgetService.editBudget(id, budget));
        return Optional.ofNullable(budget1.orElse(null)) ;
    }
    @DeleteMapping("/delete/{id}")
    public  Boolean test(@PathVariable Long id){
        return budgetService.deleteBudgetById(id);
    }
    @GetMapping("/lire")
    public Optional<List> getAllBudget(){
        Optional<List> budget = Optional.ofNullable(budgetService.getAllBudget());
        return Optional.ofNullable(budget.orElse(null));
    }
    @PostMapping("/create")
    public Budget create(@RequestBody Budget budget){
        return budgetService.createBudget(budget);
    }

}
