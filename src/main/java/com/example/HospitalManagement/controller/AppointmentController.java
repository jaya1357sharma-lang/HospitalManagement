package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Appointment;
import com.example.HospitalManagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }
    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment){
        return appointmentService.bookAppointment(appointment);
    }

}
