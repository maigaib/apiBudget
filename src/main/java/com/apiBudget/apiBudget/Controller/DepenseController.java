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
 /*   @PostMapping("/ajouter")
    public Depense MaddDepense(@RequestBody Depense depense){
        return depenseService.addDepense(depense);
    }
  */
    @GetMapping("/budget/{id}")
    public List<Depense> getAllDepensesForSpecificBudget(@PathVariable Long id){
        return depenseService.getAllDepensesForSpecificBudget(id);
    }

    @PutMapping("/modifier/{id}")
    public Depense updateDepense(@RequestBody Depense depense, @PathVariable Long id){
        return depenseService.updateDepense(depense, id);
    }
    //==========================Suppression de depense ==========================
    @DeleteMapping("/delete/{id}")
    public boolean deleteDepenseById(@PathVariable Long id){
        return depenseService.deleteDepenseById(id);
    }



}
