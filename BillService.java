package com.project.hospitalmanagementSystem.service;

import com.project.hospitalmanagementSystem.models.Bill;
import com.project.hospitalmanagementSystem.repository.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepository billRepository;

    public Page<Bill> getAllBill(int page, int size){
        try{
            System.out.println("invalid");
            Pageable pageable = PageRequest.of(page, size);
            return billRepository.findAll(pageable);
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while fetching bill  : {} ",e.getMessage());

            return null;
        }
    }
    public Bill createBill(Bill bill){
        try{
            billRepository.save(bill);
            return bill;
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while creating bill  {} : {} ",bill,e.getMessage());

            return null;
        }
    }
    public Bill getBillById(Long id){
        try{
            Optional<Bill> bill= billRepository.findById(id);
            return bill.orElse(null);
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while fetching bill with id {} : {} ",id,e.getMessage());
            return null;
        }
    }
    public void deleteById(Long id){
        try{
            System.out.println("invalid");
            billRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while deleting bill with id {} : {} ",id,e.getMessage());

        }
    }
    public Bill updateById(Long id,Bill bill){
        try{
            System.out.println("invalid");
            Optional<Bill> existingBill =billRepository.findById(id);
            if (existingBill.isPresent()){
                Bill b=existingBill.get();
                b.setAmount(bill.getAmount());
                b.setStatus(bill.getStatus());
                billRepository.save(b);
                return bill;
            }else {
                logger.error("bill with {} id not found",id);
                return null;
            }


        }catch (Exception e){
            System.out.println("error message" + e.getMessage());
            logger.error("an error occured while updating bill with id {} : {} ",id,e.getMessage());
            return bill;

        }
    }
}
