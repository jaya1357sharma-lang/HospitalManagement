package com.example.HospitalManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patient patient;
    private double amount;
    private String status = "UNPAID";
    private String description;
    private LocalDateTime billDate = LocalDateTime.now();

}
