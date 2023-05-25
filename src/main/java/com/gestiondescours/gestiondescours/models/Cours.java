package com.gestiondescours.gestiondescours.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCours;
    private String nomCours;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCours;
    private String salle;

    @ManyToOne
    private Professeur professeur;

    public Cours(String nomCours, Date dateCours, String salle) {
        this.nomCours = nomCours;
        this.dateCours = dateCours;
        this.salle = salle;
    }

    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public void setDateCours(Date dateCours) {
        this.dateCours = dateCours;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }



    @Override
    public String toString() {
        return "Cours{" +
                "idCours=" + idCours +
                ", nomCours='" + nomCours + '\'' +
                ", dateCours=" + dateCours +
                ", salle='" + salle + '\'' +
                '}';
    }

    public Cours() {
        super();
    }
}