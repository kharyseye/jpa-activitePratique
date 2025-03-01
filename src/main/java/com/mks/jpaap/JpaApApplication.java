package com.mks.jpaap;

import com.mks.jpaap.entities.Patient;
import com.mks.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        patientRepository.save(new Patient(null, "Khary", new Date(), true, 100));
        patientRepository.save(new Patient(null, "Falmata", new Date(), false, 150));
        patientRepository.save(new Patient(null, "Anida", new Date(), true, 100));
        patientRepository.save(new Patient(null, "Sidy", new Date(), true, 400));
        patientRepository.save(new Patient(null, "Mohamed", new Date(), true, 250));
        patientRepository.save(new Patient(null, "Tidiane", new Date(), true, 100));

        System.out.println("- - - - - - - LISTE DES PATIENT- - - - - - - -");
        // AFFICHER LA LISTE DES PATIENTS
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });
    }
}
