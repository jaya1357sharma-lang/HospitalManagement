package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Appointment;
import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public List<Doctor>getAllDoctor(){
        return doctorRepository.findAll();
    }
    public Doctor saveDoctor(Doctor doctor){
        // Link appointments back to this doctor before saving
        if(doctor.getAppointments()!=null){
            for(Appointment appointment :doctor.getAppointments()){
                appointment.setDoctor(doctor);
            }
        }
        return doctorRepository.save(doctor);
    }
}
