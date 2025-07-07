package com.project.hospitalmanagementSystem.controllers;

import com.project.hospitalmanagementSystem.models.Doctor;
import com.project.hospitalmanagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public Page<Doctor> getAllDoctors(@RequestParam(defaultValue = "0")int page,
                                      @RequestParam(defaultValue = "3") int size){
        System.out.println("create record");
        return doctorService.getAllDoctors(page,size);
    }
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("creates Doctor ");
        return doctorService.createDoctor(doctor);
    }
    @GetMapping("/{id}")
    public Doctor getBYID(@PathVariable Long id){
        System.out.println("get Id" + id);
        return doctorService.getDoctorById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBYID(@PathVariable Long id){
        System.out.println("delete doctors id" + id);
        doctorService.deleteById(id);
    }
    @PutMapping
    public void updateBYID(@PathVariable Long id,@RequestBody Doctor doctor){
        System.out.println("update record by id" + id);
        doctorService.updateById(id,doctor);
    }
}
