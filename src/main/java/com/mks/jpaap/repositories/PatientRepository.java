package com.mks.jpaap.repositories;

import com.mks.jpaap.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
