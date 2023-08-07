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

    @Service
    @AllArgsConstructor
    public static class TypeService{


        private final TypeRepository typeRepository;

        public List<Type> Lire() {
            return typeRepository.findAll();
        }

        public Type creer(Type type) {
            //a traver ce fonctionalite on ce comme on ecrier inser in to come SQL
            return typeRepository.save(type);
        }

        public Type getType(Long id, Type type) {
            return typeRepository.findById(id).orElseThrow(()-> new RuntimeException("Type non trouvé !"));
        }


       public Type modifier(Long id,Type type){
            return typeRepository.findById(id)
                    .map(m-> {
                        m.setNom(type.getNom());
                        return typeRepository.save(m);
                    }).orElseThrow();
       }

        public String supprimer(Long id) {
            typeRepository.deleteById(id);
            return "Type supprimer avec succès !";
        }
    }
}
