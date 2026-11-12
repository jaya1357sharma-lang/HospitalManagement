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
        // 1.  patient object sent in the JSON request
        Patient patient = appointment.getPatient();
        if(patient == null || patient.getId() == null){
                throw new RuntimeException("Patient ID is required");}
        // 2. Check if that Patient actually exist in the database
        patientRepository.findById(patient.getId())
                .orElseThrow(() ->new RuntimeException("Patient not found"));

        // 3. Get the Doctor object sent in the JSON request
        Doctor doctor = appointment.getDoctor();
        if(doctor == null || doctor.getId() == null){
            throw new RuntimeException("Doctor ID is required");}
        // 4. Check if that doctor actually exist in the database
        doctorRepository.findById(doctor.getId())
                .orElseThrow(() ->new RuntimeException("Doctor not found"));

        // 5. save the appointment
        return appointmentRepository.save(appointment);

    }
}
