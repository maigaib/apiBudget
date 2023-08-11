package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Services.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService typeService;
//=========================================== Pour ajouter un nouveau type =============================================
    @PostMapping("/ajouter")
    @Operation(summary = "Permet de créer un type")
    public Type creer(@RequestBody Type type){
        return typeService.creer(type);
    }
//=========================================== Pour avoir la liste des types =============================================
    @GetMapping("/liste")
    @Operation(summary = "Permet d'avoir la liste des types")
    public List<Type> Lire(){
        return typeService.Lire();
    }
//=========================================== Pour avoir un type specifique =============================================
    @GetMapping("/{id}")
    @Operation(summary = "Permet d'avoir un type specifique")
    public Type getType(@PathVariable Long id){
        return typeService.getType(id);
    }
//=========================================== Pour modifier un type =============================================
    @PutMapping("/modifier/{id}")
    @Operation(summary = "Permet de modifier un type")
    public Type modifier(@PathVariable Long id, @RequestBody Type type ){
        return typeService.modifier(id, type);
    }

//=========================================== Pour supprimer un type =============================================
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Permet de supprimer un type")
    public String supprimer(@PathVariable Long id){
        return typeService.supprimer(id);
    }






}
