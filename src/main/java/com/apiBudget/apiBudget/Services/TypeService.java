package com.apiBudget.apiBudget.Services;

import com.apiBudget.apiBudget.Repository.TypeRepository;
import com.apiBudget.apiBudget.Modeles.Type;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
    @Service
    @AllArgsConstructor
    public class TypeService{


        private final TypeRepository typeRepository;

        public List<Type> Lire() {
            return typeRepository.findAll();
        }

        public Type creer(Type type) {
            //a traver ce fonctionalite on ce comme on ecrier inser in to come SQL
            return typeRepository.save(type);
        }

        public Type getType(Long id) {
            return typeRepository.findById(id).orElseThrow(()-> new RuntimeException("Type non trouvé !"));
        }


       public Type modifier(Long id,Type type){
            return typeRepository.findById(id).map(m-> {
                        m.setNom(type.getNom());
                        return typeRepository.save(m);
                    }).orElseThrow();
       }

        public String supprimer(Long id) {
            typeRepository.deleteById(id);
            return "Type supprimer avec succès !";
        }
    }

