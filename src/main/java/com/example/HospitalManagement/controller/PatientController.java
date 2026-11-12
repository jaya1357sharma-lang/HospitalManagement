package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
    @Autowired
    PatientService patientService;
//    @GetMapping
//    public List<Patient> getAllPatients(){
//        return patientService.getAllPatients();
//    }
@GetMapping
public ResponseEntity<List<Patient>> getAllPatients(){
    return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK) ;
}
//    @PostMapping
//    public Patient savePatient(@RequestBody Patient patient){
//        return patientService.savePatient(patient);
//
//    }
@PostMapping
public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
    Patient savedPatient = patientService.savePatient(patient);
    return new ResponseEntity<>(savedPatient,HttpStatus.CREATED);

}
}
