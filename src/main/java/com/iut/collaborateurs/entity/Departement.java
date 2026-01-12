package com.iut.collaborateurs.entity;

import jakarta.persistence.*;

@Entity
@Table(name="departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_departement")
    private int id;

    @Column(name="nom_departement")
    private String nom;

    public Departement() {} // Constructeur vide [cite: 164]

    public Departement(String nom) {
        this.nom = nom;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
