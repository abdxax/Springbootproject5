package com.example.projrct5.controller;

import com.example.projrct5.model.Book;
import com.example.projrct5.model.Customer;
import com.example.projrct5.service.CustomerService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.customerList();
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Customer customer){
       customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Added done");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Customer customer){
        Boolean res=customerService.update(id,customer);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Update Is Done ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean res=customerService.delete(id);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Delete Is Done ");
    }
@PutMapping("/{storeId}/customer/{customerId}")
    public ResponseEntity assignToStrore(@PathVariable Integer storeId,@PathVariable Integer customerId){
        Boolean res=customerService.assignToStore(storeId,customerId);
        if(!res){
            return ResponseEntity.status(400).body("The store id or customer id is not correct");
        }
        return ResponseEntity.status(200).body("Assigin done");
    }
    @GetMapping("/getByStore/{id}")
    public ResponseEntity getByStore(@PathVariable Integer id){
        List<Customer> customers=customerService.getByStore(id);
        return  ResponseEntity.status(200).body(customers);
    }
}
