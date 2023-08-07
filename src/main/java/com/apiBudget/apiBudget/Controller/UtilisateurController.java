package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.ApiResponse;
import com.apiBudget.apiBudget.Modeles.Utilisateur;
import com.apiBudget.apiBudget.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("utilisateur")
@RestController
public class UtilisateurController {

    private final UtilisateurService userService;

    @Autowired
    public UtilisateurController(UtilisateurService userService){
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public Utilisateur getUseById(@PathVariable Long id){
        Optional<Utilisateur> user = userService.getUtilisateurById(id);
        return (Utilisateur) user.orElse(null);
    }
    @PutMapping("/update/{id}")
    public Optional<Utilisateur> updateUtilisateur(@PathVariable Long id,@RequestBody Utilisateur utilisateur){
        Optional<Utilisateur> user = Optional.ofNullable(userService.editUtilisateur(id, utilisateur));
        return Optional.ofNullable(user.orElse(null)) ;
    }
    @DeleteMapping("/delete/{id}")
    public  Boolean test(@PathVariable Long id){
        return userService.deleteUtilisateurById(id);
    }
    @GetMapping("")
    public Optional<List> getUsers(){
        Optional<List> user = Optional.ofNullable(userService.getAllUtilisateur());
        return Optional.ofNullable(user.orElse(null));
    }
    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return userService.createUtilisateur(utilisateur);
    }


    @PostMapping("/login")
    public ApiResponse login(@RequestParam String email, @RequestParam String password){
        return userService.login(email,password);
    }
}