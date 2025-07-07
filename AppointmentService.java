package com.project.hospitalmanagementSystem.service;

import com.project.hospitalmanagementSystem.models.Appointment;
import com.project.hospitalmanagementSystem.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AppointmentService {

    private static final Logger logger= LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Page<Appointment> getAllAppointment(int page, int size){
        try{
            System.out.println("into service layer");
            Pageable pageable= PageRequest.of(page, size);
            return appointmentRepository.findAll(pageable);
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("an error occured while fetching appointments  : {} ",e.getMessage());

            return null;
        }
    }
    public Appointment createAppointment(Appointment appointment){
        try{
            appointmentRepository.save(appointment);
            return appointment;
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("an error  while creating appointments {} : {} ",appointment,e.getMessage());

            return  null;
        }
    }
    public Appointment getAppointmentById(Long id){
        try{
            Optional<Appointment>appointment= appointmentRepository.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("an error  while fetching appointments by id {} : {} ",id,e.getMessage());

            return  null;
        }
    }
    public void deleteById(Long id){
        try{
            System.out.println("into service layer");
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("an error  while deleting appointments by id {} : {} ",id,e.getMessage());

        }
    }
    public Appointment updateById(Long id,Appointment appointment){
        try{
            System.out.println("into service layer");
           Optional<Appointment>  existingAppointmnet= appointmentRepository.findById(id);
           if (existingAppointmnet.isPresent()){
               Appointment a= existingAppointmnet.get();
               a.setDate(appointment.getDate());
               a.setId(appointment.getId());
               appointmentRepository.save(a);
               return appointment;
           }
           else {
               logger.error("appointmnet with {} id not found",id);
               return null;
           }
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("an error  while updating appointments by id {} : {} ",id,e.getMessage());
            return null;

        }
    }
}
