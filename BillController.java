package com.project.hospitalmanagementSystem.controllers;

import com.project.hospitalmanagementSystem.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.project.hospitalmanagementSystem.service.BillService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public Page<Bill> getAllBills(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3") int size){
        System.out.println("retrieve bills");
        return billService.getAllBill(page, size);
    }
    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        System.out.println("create bill");
        return  billService.createBill(bill);
    }
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        System.out.println("fetch bill" + id);
        return billService.getBillById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        System.out.println("delete bill" + id );
        billService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updatebyId(@PathVariable long id,@RequestBody Bill bill) {
        System.out.println("update bill" + id);
        billService.updateById(id,bill);
    }
}
