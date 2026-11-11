package com.example.HospitalManagement.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status = "BOOKED";

}
