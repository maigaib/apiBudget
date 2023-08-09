package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Modeles.Type;
import com.apiBudget.apiBudget.Repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@Service
@AllArgsConstructor
public class AlerteService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String destinateur, String expediteur, String message) {
        SimpleMailMessage alt = new SimpleMailMessage();
        alt.setTo(destinateur);
        alt.setSubject(expediteur);
        alt.setText(message);

        mailSender.send(alt);
    }

}
