package com.iut.collaborateurs.controllers;

import com.iut.collaborateurs.entity.Departement;
import com.iut.collaborateurs.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
@CrossOrigin(origins = "*") // Pour éviter les erreurs CORS
public class DepartementsController {
    @Autowired
    private DepartementService departementService;
    @GetMapping("/{id}")
    public Departement listerDepartementParId(@PathVariable("id") String id) {
        return this.departementService.getDepartementById(Integer.parseInt(id));
    }

    @GetMapping
    public List<Departement> listerDepartements (){
        return departementService.getAllDepartements();
    }
}
