package com.iut.collaborateurs.service;

import com.iut.collaborateurs.entity.Collaborateur;
import com.iut.collaborateurs.entity.Departement;
import com.iut.collaborateurs.repository.CollaborateurRepository;
import com.iut.collaborateurs.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollaborateurService {

    @Autowired
    private CollaborateurRepository collabRepo;

    @Autowired
    private DepartementRepository deptRepo;

    public List<Collaborateur> getAllCollaborateurs() {
        return collabRepo.findAll();
    }

    public Collaborateur getCollaborateurById (int id){
        return collabRepo.getReferenceById(id);
    }

    public Collaborateur saveCollaborateur (Collaborateur collaborateur){
        return collabRepo.save(collaborateur);
    }

    public Collaborateur editCollaborateur(Collaborateur collaborateur){
        return collabRepo.save(collaborateur);
    }

    public void supprCollaborateur(int id){
        System.out.println("ouais");
        collabRepo.deleteById(id);
    }

    //Calcul des statistiques
    public List<PiechartData> getStatistics() {
        List<PiechartData> stats = new ArrayList<>();
        List<Departement> depts = deptRepo.findAll();
        long totalCollabs = collabRepo.count();

        for (Departement d : depts) {
            // Compte les collaborateurs dans ce département
            long count = collabRepo.findByIdDepartement(d.getId()).size();

            if (totalCollabs > 0) {
                double percent = (double) count / totalCollabs * 100;
                stats.add(new PiechartData(d.getNom(), percent));
            }
        }
        return stats;
    }
}
