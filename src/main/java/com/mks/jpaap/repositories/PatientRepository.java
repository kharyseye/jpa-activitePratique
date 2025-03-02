package com.mks.jpaap.repositories;

import com.mks.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByMalade (boolean m);

    Page<Patient> findByMalade(boolean m, Pageable pageable);

    List<Patient> findByMaladeAndScoreLessThan (boolean m, int score);
    List<Patient> findByMaladeTrueAndScoreLessThan ( int score);
    List<Patient> findByDateNaissanceBetween (Date d1, Date d2);
    /*
    Cette methode ci dessous est utiliser lorsque l'on veut crèer une requete complexe
     */
    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z  ")
    List<Patient> chercherPatient (@Param("x") Date d1, @Param("y")Date d2, @Param("z")String nom);

    @Query("select p from Patient p where p.nom like :x and  p.score<:y  ")
    List<Patient> chercherPatientParNometScore(@Param("x") String nom, @Param("y")int scoreMin);
}
