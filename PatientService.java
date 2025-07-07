package com.project.hospitalmanagementSystem.service;

import com.project.hospitalmanagementSystem.models.Patient;

import com.project.hospitalmanagementSystem.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

 private static  final Logger logger = LoggerFactory.getLogger(PatientService.class);

       @Autowired
       private PatientRepository patientRepository;



    public Page<Patient> getAllPatients(int page,int size){
        try{
            System.out.println("into service layer");
            Pageable pageable = (Pageable) PageRequest.of(page,size);
            return patientRepository.findAll(pageable);
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("an error occured while fetching  patients : {} ",e.getMessage());
            return  null;
        }
    }
    public Patient getPatientById(Long id)
    {
        try {
            Optional<Patient> patient = patientRepository.findById(id);
            return patient.orElse(null);
        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("an error occured while fetching Patient with id {} : {} ",id,e.getMessage());
            return null;
        }
    }
    public Patient createPatient(Patient patient)
    {
        try {
            patientRepository.save(patient);
            return patient;
        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("an error occured while creating Patient  {} : {} ",patient,e.getMessage());

            return null;
        }
    }
    public void  deletePatient(Long id)
    {
        try {
            System.out.println("invalid");
            logger.info("Deleting Patient with id: {}",id);
            patientRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("an error occured while deleting Patient with id {} : {} ",id,e.getMessage());

        }
    }
    public Patient updatePatient(Long id, Patient patient)
    {
        try {
            Optional<Patient> existingPatient=patientRepository.findById(id);
            if (existingPatient.isPresent()){
                Patient p=existingPatient.get();
                p.setName(patient.getName());
                p.setAge(patient.getAge());
                patientRepository.save(p);
                return patient;
            }
            else {
                logger.error("Patient with {} id not found",id);
            return null;
            }

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());

            logger.error("an error  while updating Patient with id {} : {} ",id,e.getMessage());
            return null;

        }
    }
}
