package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }
    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }
}
