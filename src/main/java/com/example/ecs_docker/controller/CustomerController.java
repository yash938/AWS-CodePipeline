package com.example.ecs_docker.controller;


import com.example.ecs_docker.dto.Customer;
import com.example.ecs_docker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/post")
    public ResponseEntity<Customer> addCust(@RequestBody Customer customer){
        Customer customer1 = customerService.addCustomerDetails(customer);
        customer1.setId(UUID.randomUUID().toString());
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers,HttpStatus.OK);
    }
}
