package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Alerte;
import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Repository.AlerteRepository;
import com.apiBudget.apiBudget.Repository.BudgetRepository;
import com.apiBudget.apiBudget.Repository.DepenseRepository;
import com.apiBudget.apiBudget.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class DepenseService {
    @Autowired
    private DepenseRepository depenseRepository;
    @Autowired

    private AlerteService alerteService;
    @Autowired

    private TypeRepository typeRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private AlerteRepository alerteRepository;
    public List<Depense> getAllDepensesForSpecificBudget(Long id){

        return depenseRepository.findDepensesByBudgetId(id);
    }

    public Depense addDepense(Depense depense) {


        //=================Obtenir le budget a travers son id ================

        Budget budget = budgetRepository.findBudgetById(depense.getBudget().getId());

        //================pour verifier que le budget existe==============
        if((budget==null)) {
            throw new RuntimeException("Ce budget n'existe pas");
        }
        //===============Verification de la validité du budget===============
        if( (depense.getBudget().getDateFin().isBefore(LocalDate.now()))){
            throw new RuntimeException("Ce budget est expiré.");
        }
        //======================Lier la depense au budget ===========================
        depense.setBudget(budget);

        //=================Obtenir le type a travers son id ================

       Type type = typeRepository.findTypeById(depense.getType().getId());
       if (type==null)
           throw new RuntimeException("Ce type n'exite pas");
         depense.setType(type);

         // ======Verifier si la depense est superieur au montant de notre budget======

        if (depense.getMontant() > depense.getBudget().getMontantMax()) {
            throw new RuntimeException("Le montant de la depense est superieur a votre budget");
        }
        //===============Validation de la date de la depense================
        depense.setDate(LocalDate.now());
        if(depense.getDate().isAfter(LocalDate.now())&& depense.getBudget().getDateFin().isBefore(LocalDate.now())) {
            throw new RuntimeException("La date entrée est incorrect");
        }

        //============pour deduire notre depense de notre budget=============
        budget.setBudgetRestant(budget.getBudgetRestant()-depense.getMontant());

        //=========================Gestion de l'alerte=======================

        if (budget.getBudgetRestant() <= budget.getMontantAlert()) {
            alerteService.sendEmail(type.getUtilisateur().getEmail(), "Alerte !!!", "vous avez atteint votre montant d'alerte  il vous reste " + budget.getBudgetRestant() + " F CFA de budget");
            Alerte alerte = new Alerte();
            alerte.setDestinateur(type.getUtilisateur().getEmail());
            alerte.setMessage("Vous avez atteint votre montant d'alerte  il vous reste " + budget.getBudgetRestant() + " F CFA de budget");
            alerte.setDate(LocalDate.now());
            alerte.setUtilisateur(type.getUtilisateur());
            alerte.setBudget(depense.getBudget());
            alerteService.addAlerte(alerte);
        }

        return depenseRepository.save(depense);

    }

    public Depense updateDepense(Depense depense, Long id) {
        Depense exDepense = depenseRepository.findById(id).orElse(null);
        if (exDepense == null) {
            throw new RuntimeException("La depense correspondant n'existe pas.");
        }else {
        exDepense.setMontant(depense.getMontant());
        exDepense.setDescription(depense.getDescription());
        exDepense.setDate(depense.getDate());
        return depenseRepository.save(exDepense);}
    }

    public String deleteDepenseById(Long id){
        //====================Retrouver la depense=================

        Depense depense = depenseRepository.findDepenseById(id);
        //============Retrouver le budget correspondant à la depense=======

        Budget budget = depense.getBudget();
        //===Recuper le montant de la depense et le rajouter au montant restant du budget====

        budget.setBudgetRestant(budget.getBudgetRestant()+depense.getMontant());
        budgetRepository.save(budget);
        depenseRepository.deleteById(id);
        return "Depense annulée";
    }


    public List<Depense> getAllDepenses() {
        return depenseRepository.findAll();
    }

    public Depense getSpecificDepense(Long id) {
        return depenseRepository.findDepenseById(id);
    }
}
