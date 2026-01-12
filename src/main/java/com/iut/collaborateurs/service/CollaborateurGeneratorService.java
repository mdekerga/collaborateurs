package com.iut.collaborateurs.service;

import com.github.javafaker.Faker;
import com.iut.collaborateurs.entity.Collaborateur;
import com.iut.collaborateurs.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurGeneratorService {

    @Autowired
    private CollaborateurRepository collaborateurRepository;

    public Collaborateur generateCollaborateur() {
        Faker faker = new Faker();
        Collaborateur c = new Collaborateur();
        c.setNom(faker.name().lastName());
        c.setPrenom(faker.name().firstName());
        c.setMatricule(faker.idNumber().valid());
        c.setAdresse(faker.address().fullAddress());
        // Affectation aléatoire à un département (ex: 1 à 5)
        c.setIdDepartement(faker.number().numberBetween(1, 6));
        return c;
    }

    // Enregistre X collaborateurs en base [cite: 16]
    public void generateCollabs(Integer collabNumber) {
        for (int i = 0; i < collabNumber; i++) {
            collaborateurRepository.save(generateCollaborateur());
        }
    }
}