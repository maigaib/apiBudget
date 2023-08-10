package com.apiBudget.apiBudget.Controller;

import com.apiBudget.apiBudget.Modeles.Alerte;
import com.apiBudget.apiBudget.Services.AlerteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class AlerteControlleur {

    private final AlerteService alerteService;

    @PostMapping("/alerte")
    public void sendAlerteEmail(@RequestBody Alerte alerte){
        alerteService.sendEmail(
                alerte.getDestinateur(),
                alerte.getMessage(),
                alerte.getExpediteur()
        );
    }
}
