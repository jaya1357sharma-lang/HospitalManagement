package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Appointment;
import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.repository.AppointmentRepository;
import com.example.HospitalManagement.repository.DoctorRepository;
import com.example.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService  {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    public List<Appointment>getAllAppointments(){
        return appointmentRepository.findAll();
    }
    public Appointment bookAppointment(Appointment appointment){
        //Check if patient id actually exist in the database
        Patient patient = patientRepository.findById(appointment.getPatientId())
                .orElseThrow(() ->new RuntimeException("Patient not found"));
        //Check if doctor id actually exist in the database
        Doctor doctor = doctorRepository.findById(appointment.getDoctorId())
                .orElseThrow(() ->new RuntimeException("Doctor not found"));

        ///  save the appointment
        return appointmentRepository.save(appointment);

    }
}
