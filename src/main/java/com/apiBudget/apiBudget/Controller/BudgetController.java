package com.apiBudget.apiBudget.Controller;


import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Services.BudgetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("budget")
@RestController
@AllArgsConstructor
public class BudgetController {
    private final BudgetService budgetService;


    @GetMapping("/{id}")
    @Operation(summary = "Permet d'avoir un budget specifique")
    public Budget getBudgetById(@PathVariable Long id){
        Optional<Budget> user = budgetService.getBudgetById(id);
        return (Budget) user.orElse(null);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Permet de modifier un budget")
    public Optional<Budget> updateBudget(@PathVariable Long id,@RequestBody Budget budget){
        Optional<Budget> budget1 = Optional.ofNullable(budgetService.editBudget(id, budget));
        return Optional.ofNullable(budget1.orElse(null)) ;
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Permet de supprimer un budget")
    public  Boolean test(@PathVariable Long id){
        return budgetService.deleteBudgetById(id);
    }
    @GetMapping("/liste")
    @Operation(summary = "Permet d'avoir la liste des budgets")
    public Optional<List> getAllBudget(){
        Optional<List> budget = Optional.ofNullable(budgetService.getAllBudget());
        return Optional.ofNullable(budget.orElse(null));
    }
    @PostMapping("/ajouter")
    @Operation(summary = "Permet d'ajouter un budget")
    public Budget create(@RequestBody Budget budget){
        return budgetService.createBudget(budget);
    }

}
