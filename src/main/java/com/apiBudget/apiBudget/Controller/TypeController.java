package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Services.TypeService;
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
    public Type creer(@RequestBody Type type){
        return typeService.creer(type);
    }
//=========================================== Pour avoir la liste des types =============================================
    @GetMapping("/liste")
    public List<Type> Lire(){
        return typeService.Lire();
    }
//=========================================== Pour avoir un type specifique =============================================
    @GetMapping("/{id}")
    public Type getType(@PathVariable Long id){
        return typeService.getType(id);
    }
//=========================================== Pour modifier un type =============================================
    @PutMapping("/modifier/{id}")
    public Type modifier(@PathVariable Long id, @RequestBody Type type ){
        return typeService.modifier(id, type);
    }

//=========================================== Pour supprimer un type =============================================
    @DeleteMapping("/delete/{id}")
    public String supprimer(@PathVariable Long id){
        return typeService.supprimer(id);
    }






}
