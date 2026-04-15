package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.LoginRequest;
import com.example.projectBackend.Entity.Customer;
import com.example.projectBackend.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService services;

//    @PostMapping
//    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
//        Customer savedCustomer = services.Create(customer);
//        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
//    }

    @PostMapping("/register")

    public ResponseEntity<?>Resgister(@RequestBody Customer customer){
        return services.Registration(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return services.login(request);
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getData() {
        List customerList = services.getallCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer =services.updateCustomer(id,customer);
        return  new ResponseEntity<>(updatedCustomer,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCustomer(@PathVariable Long id){
        services.deletecustomer(id);
        return  new ResponseEntity<>("Customer deleted successfully",HttpStatus.OK);

    }



}

