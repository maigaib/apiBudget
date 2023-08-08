package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("Type")
@RestController
public class TypeController {

    @Autowired
    TypeService typeService;

    @PostMapping("/{budgetId}/ajouter")
    public Type addType(@RequestBody Type type, @PathVariable Long budgetId ){
        return type.addType(type, budgetId);
    }
    @GetMapping("/budget/{budgetId}")
    public List<Type> getAllTypeForSpecificBudget(@PathVariable Long budgetId){
        return typeService.getAllTypeForSpecificBudget(budgetId);
    }

    @PutMapping("/modifier/{depenseId}")
    public Type updateType(@RequestBody Type type, @PathVariable Long depenseId){
        return typeService.getType(depenseId, type);
    }
    //=====================================S
    @DeleteMapping("/delete/{depenseId}")
    public boolean deleteTypeById(@PathVariable Long depenseId){
        return typeService.deleteTypeById(depenseId);
    }
}
