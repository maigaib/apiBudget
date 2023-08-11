package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("type")
@RestController
public class TypeController {

    @Autowired
    TypeService typeService;

    @PostMapping("/ajouter")
    public Type addType(@RequestBody Type type , @PathVariable Long depenseId){
        return typeService.creer(type);
    }
    @GetMapping("/lire")
    public List<Type> getAllTypeForSpecificBudget(@RequestBody Type type, @PathVariable Long depenseId){
        return typeService.Lire();
    }

    @PutMapping("/modifier/{depenseId}")
    public Type updateType(@RequestBody Type type, @PathVariable Long depenseId){
        return typeService.getType(type,depenseId);
    }
    //=====================================S
    @DeleteMapping("/delete")
    public String deleteTypeById(@PathVariable Long depenseId){

        return typeService.supprimer(depenseId);
}

}
