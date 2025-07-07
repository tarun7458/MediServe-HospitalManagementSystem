package com.project.hospitalmanagementSystem.controllers;
import com.project.hospitalmanagementSystem.models.Patient;
import com.project.hospitalmanagementSystem.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public Page<Patient> getAllPatients(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "3") int size){
        System.out.println("Fetching patients");
        return patientService.getAllPatients(page,size);
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("creates Patient");
        return patientService.createPatient(patient);
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        System.out.println("fetch Id");
        return patientService.getPatientById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable Long id){
        System.out.println("deleting id");
        patientService.deletePatient(id);
    }
    @PutMapping("/{id}")
    public Patient updateById(@PathVariable Long id,@RequestBody Patient patient){
        System.out.println("updating id");
        return  patientService.updatePatient(id,patient);
    }
}
