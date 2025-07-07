package com.project.hospitalmanagementSystem.service;


import com.project.hospitalmanagementSystem.models.Doctor;
import com.project.hospitalmanagementSystem.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    public Page<Doctor> getAllDoctors(int page, int size){
        try{
            System.out.println("into service layer");
            Pageable pageable = PageRequest.of(page, size);
            return doctorRepository.findAll(pageable);
        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("error while fetching all doctors : {}",e.getMessage());
            return  null;
        }
    }
    public Doctor createDoctor(Doctor doctor){
        try{
            doctorRepository.save(doctor);
            return doctor;
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while creating doctors  {} : {} ",doctor,e.getMessage());
            return null;
        }
    }
    public Doctor getDoctorById(Long id){
        try{
            Optional<Doctor> doctor=doctorRepository.findById(id);
            return doctor.orElse(null);
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error  while fetching Doctor with id {} : {} ",id,e.getMessage());

            return null;
        }
    }
    public  void deleteById(Long id){
        try{
            System.out.println("invalid");
            logger.info("Deleting doctor with id: {}",id);
            doctorRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while deleting Doctor with id {} : {} ",id,e.getMessage());

        }
    }
    public  Doctor updateById(Long id , Doctor doctor) {
        try {
            System.out.println("invalid");
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if (existingDoctor.isPresent()) {
                Doctor d = existingDoctor.get();
                d.setName(doctor.getName());
                doctorRepository.save(d);
                return doctor;
            }else {
                logger.error("Patient with {} id not found",id);
                return null;
            }

        } catch (Exception e) {
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while updating Doctor with id {} : {} ", id, e.getMessage());
            return  null;

        }
    }
}
