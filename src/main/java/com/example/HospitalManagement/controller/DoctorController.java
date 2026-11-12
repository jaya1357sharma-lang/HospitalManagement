package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctor(){
        List<Doctor>doctors = doctorService.getAllDoctor();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){

        return new ResponseEntity<>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
    }
}
