package com.project.hospitalmanagementSystem.repository;
import com.project.hospitalmanagementSystem.models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
