package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Services.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("depense")
@RestController
public class DepenseController {
    @Autowired
    DepenseService depenseService;

    @PostMapping("/ajouter")
    public Depense addDepense(@RequestBody Depense depense){
        return depenseService.addDepense(depense);
    }
    @GetMapping("/budget/{budgetId}")
    public List<Depense> getAllDepensesForSpecificBudget(@PathVariable Long Id){
        return depenseService.getAllDepensesForSpecificBudget(Id);
    }

    @PutMapping("/modifier/{depenseId}")
    public Depense updateDepense(@RequestBody Depense depense, @PathVariable Long depenseId){
        return depenseService.updateDepense(depense, depenseId);
    }
    //=====================================S
    @DeleteMapping("/delete/{depenseId}")
    public boolean deleteDepenseById(@PathVariable Long depenseId){
        return depenseService.deleteDepenseById(depenseId);
    }



}
