package com.iut.collaborateurs.entity;

import jakarta.persistence.*;

@Entity
@Table(name="collaborateurs")
public class Collaborateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String emailPro;
    private String numSecu;
    private String photo; // URL de la photo
    private boolean actif;
    private String intitulePoste;

    // Identifiant du département (Entier simple selon TP) [cite: 154]
    private int idDepartement;

    private String civilite;
    private String nomBanque;
    private String bic;
    private String ban;

    public Collaborateur() {}

    // Getters et Setters (Omis pour brièveté, à générer via IDE)
    public int getIdDepartement() { return idDepartement; }
    public void setIdDepartement(int idDepartement) { this.idDepartement = idDepartement; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public void setEmailPro(String emailPro) {
        this.emailPro = emailPro;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }
    // ... ajouter les autres getters/setters
}
