package com.example.HospitalManagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Long patientId;
//    private Long doctorId;
    @ManyToOne
    @JoinColumn(name = "patient_id")
   // @JsonManagedReference///  prevents infinite recursion
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status = "BOOKED";

}
