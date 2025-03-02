package com.mks.jpaap;

import com.mks.jpaap.entities.Patient;
import com.mks.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {


    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 100; i++) {
            patientRepository.save(new Patient(null, "Khary", new Date(), Math.random()>0.5?true:false, (int) (Math.random() * 100)));
        }

        /*patientRepository.save(new Patient(null, "Khary", new Date(), true, 100));
        patientRepository.save(new Patient(null, "Falmata", new Date(), false, 150));
        patientRepository.save(new Patient(null, "Anida", new Date(), true, 100));
        patientRepository.save(new Patient(null, "Sidy", new Date(), true, 400));
        patientRepository.save(new Patient(null, "Mohamed", new Date(), true, 250));
        patientRepository.save(new Patient(null, "Tidiane", new Date(), true, 100));*/

        System.out.println("- - - - - - - LISTE DES PATIENT PAR PAGE- - - - - - - -");
        // AFFICHER LA LISTE DES PATIENTS
        //afficher la liste des patients par page
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0, 5));
        System.out.println("Total page : "+ patients.getTotalPages());
        System.out.println("Total elements : "+ patients.getTotalElements());
        System.out.println("Numero de page : "+ patients.getNumber());
        //List<Patient> content = patients.getContent();

        //afficher la liste des patient dont malade = true
        Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0, 5));
        byMalade.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });

        System.out.println("**********List des patients par nom et score**********");
        //affichage de la liste des patients par nom et par scoremin
        List<Patient> patientlist = patientRepository.chercherPatientParNometScore("%h%", 40);
        patientlist.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });

        System.out.println("* * * * * * * * * * *PATIENT AVEC ID = 1 * * * * * * * * * * *");
        Patient patient = patientRepository.findById(2L).orElseThrow(()->new RuntimeException("Patient not found"));
        if (patient != null){
            System.out.println("Nom du patient : "+patient.getNom());
            System.out.println("etat : "+patient.isMalade());
            System.out.println("Score : "+patient.getScore());
        }
        patient.setScore(800);
        patientRepository.save(patient);
       // patientRepository.deleteById(1L);
    }
}
