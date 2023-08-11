package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Categorie;
import com.apiBudget.apiBudget.Services.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class ControllerCategorie {

    private final CategorieService categorieService;

    //==============Creation de categories=============

    @PostMapping("/ajouter")
    @Operation(summary = "Permet de creer une categorie")
    public Categorie create(@RequestBody Categorie categorie){
        return categorieService.creer(categorie);
    }

    //===============Liste des categorie crées===========
    @GetMapping("/liste")
    @Operation(summary = "Permet d'avoir la liste des categories")
    public List<Categorie> read(){
        return categorieService.afficher();
    }

    //==============Modification de categories=============

    @PutMapping("/modifier/{id}")
    @Operation(summary = "Permet de modifier une categorie")
    public Categorie update(@PathVariable Long id, @RequestBody Categorie categorie){
        return categorieService.modifier(id, categorie);
    }

    //==============Suppression de categories=============

    @DeleteMapping("/supprimer/{id}")
    @Operation(summary = "Permet de supprimer une categorie")
    public String delete(@PathVariable Long id){
        return categorieService.supprimer(id);
    }
}
