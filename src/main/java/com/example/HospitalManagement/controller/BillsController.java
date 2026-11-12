package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Bills;
import com.example.HospitalManagement.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")

public class BillsController {
    @Autowired
    private BillsService billsService;
    @GetMapping
    public ResponseEntity<List<Bills>>getAllBills(){
        List<Bills>bills = billsService.getAllBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Bills> generateBill(@RequestBody Bills bills){
        Bills generatedBill = billsService.generateBills(bills);
        return new ResponseEntity<>(generatedBill,HttpStatus.CREATED);
    }
    @PatchMapping("/{id}/pay")
    public ResponseEntity<Bills> payBills(@PathVariable Long id){
        Bills paidBill = billsService.payBill(id);
        return new ResponseEntity<>(paidBill,HttpStatus.OK);
    }
}
