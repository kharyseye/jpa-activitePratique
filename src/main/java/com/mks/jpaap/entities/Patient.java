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
