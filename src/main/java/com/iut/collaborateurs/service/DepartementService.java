package com.iut.collaborateurs.service;

import com.iut.collaborateurs.entity.Departement;
import com.iut.collaborateurs.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartements (){
        return departementRepository.findAll();
    }

    public Departement getDepartementById (int id){
        return departementRepository.getReferenceById(id);
    }

    public Departement saveDepartement (Departement departement){
        return departementRepository.save(departement);
    }
}
