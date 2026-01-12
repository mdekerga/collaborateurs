package com.iut.collaborateurs.controllers;

import com.iut.collaborateurs.entity.Collaborateur;
import com.iut.collaborateurs.service.CollaborateurGeneratorService;
import com.iut.collaborateurs.service.CollaborateurService;
import com.iut.collaborateurs.service.PiechartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaborateurs")
@CrossOrigin(origins = "*") // Pour éviter les erreurs CORS
public class CollaborateurController {

    @Autowired
    private CollaborateurService collaborateurService;

    @Autowired
    private CollaborateurGeneratorService generatorService;

    @GetMapping
    public List<Collaborateur> listerCollaborateurs() {
        return collaborateurService.getAllCollaborateurs();
    }

    // Endpoint spécifique TP 4 pour D3.js [cite: 25]
    @GetMapping("/departement/piechart")
    public List<PiechartData> getPieChartData() {
        return collaborateurService.getStatistics();
    }

    // Endpoint utilitaire pour générer des données (Fake)
    @PostMapping("/generate/{nb}")
    public void generateData(@PathVariable Integer nb) {
        generatorService.generateCollabs(nb);
    }

    @PutMapping("/{id}")
    public void editCollaborateur(@PathVariable("id") String id,@RequestBody Collaborateur collaborateur){
        collaborateurService.editCollaborateur(collaborateur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCollaborateur(@PathVariable("id") String id){
        collaborateurService.supprCollaborateur(Integer.parseInt(id));
    }
}
