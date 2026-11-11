package com.example.HospitalManagement.repository;

import com.example.HospitalManagement.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepository extends JpaRepository<Bills,Long> {

}
