package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Appointment;
import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();

//        try {
//            System.out.println("fetching the patients");
//            return new ArrayList<>();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
    }
    public Patient savePatient(Patient patient){
        if(patient.getAppointments()!=null){
            for(Appointment appointment :patient.getAppointments()){
                appointment.setPatient(patient);
            }
        }
        return patientRepository.save(patient);

    }

}
