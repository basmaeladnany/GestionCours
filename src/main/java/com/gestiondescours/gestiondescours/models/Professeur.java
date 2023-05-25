package com.gestiondescours.gestiondescours.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesseur;
    private String nomProfesseur;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @PastOrPresent
    private Date dateIntegr;
    private String specialite;

    @OneToMany(mappedBy = "professeur")
    private List<Cours> cours;

    public Professeur(String nomProfesseur, Date dateIntegr, String specialite) {
        this.nomProfesseur = nomProfesseur;
        this.dateIntegr = dateIntegr;
        this.specialite = specialite;
    }

    public Long getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Long idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public String getNomProfesseur() {
        return nomProfesseur;
    }

    public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }

    public Date getDateIntegr() {
        return dateIntegr;
    }

    public void setDateIntegr(Date dateIntegr) {
        this.dateIntegr = dateIntegr;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Professeur() {
        super();
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "idProfesseur=" + idProfesseur +
                ", nomProfesseur='" + nomProfesseur + '\'' +
                ", dateIntegr=" + dateIntegr +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}

