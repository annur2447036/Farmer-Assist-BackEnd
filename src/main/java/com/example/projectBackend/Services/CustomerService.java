package com.example.projectBackend.Services;

import com.example.projectBackend.DTO.LoginRequest;
import com.example.projectBackend.Entity.Customer;
import com.example.projectBackend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

//    public Customer Create(Customer customer) {
//
//        return repo.save(customer);

    public ResponseEntity<?>Registration(Customer customer){
        Optional<Customer> byEmail = repo.findByEmail(customer.getEmail());

        if (byEmail.isPresent()){
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }
        Customer save =repo.save(customer);
        customer.setPassword(null);
        return ResponseEntity.ok(save);

    }
    public List<Customer> getallCustomer(){
        return repo.findAll();
    }

    public Customer updateCustomer(Long id,Customer customer){
        Customer exist =repo.findById(id).get();
        exist.setName(customer.getName());
        exist.setCity(customer.getCity());
        exist.setContact(customer.getContact());
        exist.setEmail(customer.getEmail());
        exist.setAddress(customer.getAddress());
        exist.setPassword(customer.getPassword());
        return repo.save(exist);

    }
    public void deletecustomer(Long id){
        if (repo.existsById(id)){
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public ResponseEntity<?> login(LoginRequest request){
        Optional<Customer> byEmail = repo.findByEmail(request.getEmail());
        if(byEmail.isPresent()){
            Customer customer = byEmail.get();
            if(customer.getPassword().equals(request.getPassword())){
                customer.setPassword(null); // hide password
                return ResponseEntity.ok(customer);
            }
            return ResponseEntity.status(401).body("Invalid username password");
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }
}

