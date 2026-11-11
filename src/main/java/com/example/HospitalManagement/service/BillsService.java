package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Bills;
import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.repository.BillsRepository;
import com.example.HospitalManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsService {
    @Autowired
    //1. Add patient Repository to check if patient exists

    private PatientRepository patientRepository;
    @Autowired
    private BillsRepository billsRepository;
    public List<Bills>getAllBills(){
        return billsRepository.findAll();
    }
    public Bills generateBills(Bills bills){
        // 2. check if the patient exists first
        Patient patient = patientRepository.findById(bills.getPatientId())
                .orElseThrow(()-> new RuntimeException("Cannot generate the bills : Patient not found with ID " +bills.getPatientId()));
        // 3. if patient exists, save the bill
        return billsRepository.save(bills);
    }

    // Add new feature : Mark a bill as paid
    public Bills payBill(Long billsId){
        Bills bills = billsRepository.findById(billsId)
                .orElseThrow(() -> new RuntimeException("Bills not found"));
        bills.setStatus("PAID");
        return  billsRepository.save(bills);

    }

}
