package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Services.DepenseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("depense")
@RestController
public class DepenseController {
    @Autowired
    DepenseService depenseService;

    @PostMapping("/ajouter")
    @Operation(summary = "Permet de créer une depense")
    public Depense addDepense(@RequestBody Depense depense){
        return depenseService.addDepense(depense);
    }


 /*   @PostMapping("/ajouter")
    public Depense MaddDepense(@RequestBody Depense depense){
        return depenseService.addDepense(depense);
    }
  */

    @GetMapping("/liste")
    @Operation(summary = "Permet d'avoir toute les depenses")
    public List<Depense> getAllDepenses(){
        return depenseService.getAllDepenses();
    }
    //==================================================
    @GetMapping("/{id}")
    @Operation(summary = "Permet d'avoir une depense specifique")
    public Depense getSpecificDepense(@PathVariable Long id){
        return depenseService.getSpecificDepense(id);
    }

 /*   @PostMapping("/ajouter")
    public Depense MaddDepense(@RequestBody Depense depense){
        return depenseService.addDepense(depense);
    }
  */
    @GetMapping("/budget/{id}")
    @Operation(summary = "Permet d'avoir les depenses liés à un budget specifique")

    public List<Depense> getAllDepensesForSpecificBudget(@PathVariable Long id){
        return depenseService.getAllDepensesForSpecificBudget(id);
    }

    @PutMapping("/modifier/{id}")
    @Operation(summary = "Permet de modifier une depense")
    public Depense updateDepense(@RequestBody Depense depense, @PathVariable Long id){
        return depenseService.updateDepense(depense, id);
    }


    //==========================Suppression de depense ==========================

    //=====================================S

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Permet de supprimer une depense")
    public String deleteDepenseById(@PathVariable Long id){
        return depenseService.deleteDepenseById(id);
    }




}
