package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.ApiResponse;
import com.apiBudget.apiBudget.Modeles.Utilisateur;
import com.apiBudget.apiBudget.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id){
        return utilisateurRepository.findById(id);
    }

    public Utilisateur findUtilisateurById(Long id){
        return utilisateurRepository.findById(id).get();
    }
    public Utilisateur editUtilisateur(Long id, Utilisateur utilisateur){
       Utilisateur user = utilisateurRepository.findById(id)
                .map(p ->{
                    p.setName(utilisateur.getName());
                    p.setPassword(utilisateur.getPassword());
                    return utilisateurRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Quiz non trouvé"));
        return user;
    }

    public ApiResponse login(String email , String password){

        Utilisateur user = utilisateurRepository.findByEmail(email);
        if(user == null) {
           // throw new RuntimeException("Password mismatch.");
            return new ApiResponse(200, "Couple email et mot de passe ne correspond pas", null) ;
        }
        if(!user.getPassword().equals(password)){
            return new ApiResponse(200, "Couple email et mot de passe ne correspond pas", null);
        }
        return new ApiResponse(200, "Login success", user) ;
    }
    public boolean deleteUtilisateurById(Long id){
        utilisateurRepository.deleteById(id);
        return true;
    }
}
