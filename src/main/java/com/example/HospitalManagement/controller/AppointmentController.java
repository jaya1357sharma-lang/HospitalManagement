package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Appointment;
import com.example.HospitalManagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
//    @GetMapping
//    public List<Appointment> getAllAppointments(){
//        return appointmentService.getAllAppointments();
//    }
@GetMapping
public ResponseEntity<List<Appointment>> getAllAppointments(){
    return ResponseEntity.ok(appointmentService.getAllAppointments());
}
//    @PostMapping
//    public Appointment bookAppointment(@RequestBody Appointment appointment){
//        return appointmentService.bookAppointment(appointment);
//    }
    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
    Appointment booked = appointmentService.bookAppointment(appointment);
        return new ResponseEntity<>(booked, HttpStatus.CREATED);
    }


}
