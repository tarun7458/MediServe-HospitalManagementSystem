package com.project.hospitalmanagementSystem.controllers;

import com.project.hospitalmanagementSystem.models.Appointment;
import com.project.hospitalmanagementSystem.service.AppointmentService;

import com.project.hospitalmanagementSystem.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/Appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private  WebhookService webhookService;

    @GetMapping
    public Page<Appointment> getAllAppointments(@RequestParam(defaultValue = "0")int page,
                                                @RequestParam(defaultValue = "3")int size){
        System.out.println("list of al appointments");
        return appointmentService.getAllAppointment(page,size);
    }
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointmentRequest){
        System.out.println("creates appointments");

        Appointment appointment=appointmentService.createAppointment(appointmentRequest);

        // defining payload

        Map<String , Object> payload=new HashMap<>();
        payload.put("appointmnetID",appointment.getId());
        payload.put("patientId",appointment.getPatientId());
        payload.put("doctorId",appointment.getDoctorId());
        payload.put("appointmnetDate",appointment.getDate());

        //send webhook

        String webhookUrl="http://localhost:8081/webhook";
        webhookService.sendWebhook(webhookUrl,payload);

        return appointment;


    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        System.out.println("fetch appointments" + id);
        return appointmentService.getAppointmentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        System.out.println("delete Appointment"+ id);
        appointmentService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id,@RequestBody Appointment appointment) {
        System.out.println("updates Appointment"+ id);
        appointmentService.updateById(id,appointment);
    }
}
