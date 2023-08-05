package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Categorie;
import com.apiBudget.apiBudget.Repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieService {

    private final CategorieRepository categorieRepository;

    //================Methode créer===============

    public Categorie creer(Categorie categorie){
        return categorieRepository.save(categorie);
    }
    //==============lister les categorie  creer============

    public List<Categorie> afficher(){
        return categorieRepository.findAll();
    }

    //===============Modifier categorie============
    public Categorie modifier(Long id, Categorie categorie){
        return categorieRepository.findById(id)
                .map(m-> {
                    m.setLibelle(categorie.getLibelle());
                    return categorieRepository.save(m);
                }).orElseThrow(()-> new RuntimeException("Categorie non retrouvée!!!"));
    }
    //===============Supprimer categorie==================
    public String supprimer(Long id){
        categorieRepository.deleteById(id);
        return "Categorie supprimer !!!";
    }
}
