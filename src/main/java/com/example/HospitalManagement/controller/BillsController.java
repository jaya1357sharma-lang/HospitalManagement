package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Bills;
import com.example.HospitalManagement.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")

public class BillsController {
    @Autowired
    private BillsService billsService;
    @GetMapping
    public List<Bills>getAllBills(){
        return billsService.getAllBills();
    }
    @PostMapping
    public Bills generateBill(@RequestBody Bills bills){
        return billsService.generateBills(bills);
    }
    @PatchMapping("/{id}/pay")
    public Bills payBills(@PathVariable Long id){
        return billsService.payBill(id);
    }
}
