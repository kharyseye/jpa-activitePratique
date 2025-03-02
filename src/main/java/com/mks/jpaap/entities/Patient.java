package com.mks.jpaap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean malade;

    private int score;

    public int getScore() {
        return score;
    }

    public boolean isMalade() {
        return malade;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMalade(boolean malade) {
        this.malade = malade;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Long getId() {
        return id;
    }

    public Patient(Long id, String nom, Date date, boolean b, int i) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = date;
        this.malade = b;
        this.score = i;
    }
    public Patient(){};
}
