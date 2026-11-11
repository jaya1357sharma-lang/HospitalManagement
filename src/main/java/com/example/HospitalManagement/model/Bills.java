package com.example.HospitalManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long patientId;
    private double amount;
    private String status;

}
