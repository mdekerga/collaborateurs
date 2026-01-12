package com.iut.collaborateurs.listener;

import com.iut.collaborateurs.entity.Departement;
import com.iut.collaborateurs.repository.DepartementRepository;
import com.iut.collaborateurs.service.CollaborateurGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializerListener {

    @Autowired
    private DepartementRepository deptRepo;

    @Autowired
    private CollaborateurGeneratorService genService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        // Création des départements [cite: 277]
        if(deptRepo.count() == 0) {
            deptRepo.saveAll(Arrays.asList(
                    new Departement("Informatique"),
                    new Departement("RH"),
                    new Departement("Comptabilité"),
                    new Departement("Marketing"),
                    new Departement("Vente")
            ));

            // Génération de 50 collaborateurs fictifs pour le TP 4
            genService.generateCollabs(50);
        }
    }
}
