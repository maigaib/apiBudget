package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Budget;
import com.apiBudget.apiBudget.Modeles.Depense;
import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Repository.BudgetRepository;
import com.apiBudget.apiBudget.Repository.DepenseRepository;
import com.apiBudget.apiBudget.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Depense> getAllDepensesForSpecificBudget(Long id){
        return depenseRepository.findDepensesByBudgetId(id);
    }

    public Depense addDepense(Depense depense) {
       Budget budget = budgetRepository.findBudgetById(depense.getBudget().getId());
       Type type = typeRepository.findTypeById(depense.getType().getId());
       depense.setBudget(budget);

       //pour verifier que le budget existe
       if(budget==null)
            throw  new RuntimeException("Ce budget n'existe pas");

        // pour voir si la depense est superieur à notre budget
        if (depense.getMontant() > depense.getBudget().getMontantMax())
            throw new RuntimeException("Le montant de la depense est superieur a votre budget");

        //pour deduire notre depense de notre budget
        Double budgetMontantRestant = budget.getBudgetRestant()-depense.getMontant();
        budget.setBudgetRestant(budgetMontantRestant);

        // pour l'alerte
        if (budgetMontantRestant <= budget.getMontantAlert())
            alerteService.sendEmail(type.getUtilisateur().getEmail(),"Doucoure", "vous avez atteint votre montant d'alerte  il vous reste "+budgetMontantRestant+"de budget");

            depense.setDate(LocalDate.now());
        return depenseRepository.save(depense);

    }

    public Depense updateDepense(Depense depense, Long id) {
        Depense exDepense = depenseRepository.findById(id).orElse(null);
        if (exDepense == null) {
            return null;
        }else {
        exDepense.setMontant(depense.getMontant());
        exDepense.setDescription(depense.getDescription());
        exDepense.setDate(depense.getDate());
        return depenseRepository.save(exDepense);}
    }

    public boolean deleteDepenseById(Long id){
        depenseRepository.deleteById(id);
        return true;
    }


}
