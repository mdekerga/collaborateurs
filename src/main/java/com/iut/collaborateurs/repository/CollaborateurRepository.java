package com.iut.collaborateurs.repository;

import com.iut.collaborateurs.entity.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
    List<Collaborateur> findByIdDepartement(int idDepartement);
}
