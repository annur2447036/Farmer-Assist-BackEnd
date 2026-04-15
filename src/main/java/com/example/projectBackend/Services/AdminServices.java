package com.example.projectBackend.Services;

import com.example.projectBackend.Entity.Admin;
import com.example.projectBackend.Repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServices {

    private final AdminRepository adminRepository   ;

    public AdminServices(AdminRepository adminRepository){

        this.adminRepository = adminRepository;
    }
    public ResponseEntity<?>create(Admin admin){

       Optional<Admin> byUserName=adminRepository.findByUsername(admin.getUsername());
       if (byUserName.isPresent()){
           return ResponseEntity.badRequest().body("Username Aleday Existed");

       }
       Admin save =adminRepository.save(admin);
       save.setPassword(null);
       return ResponseEntity.ok(save);

    }
    public ResponseEntity<?>login(Admin admin){
        Optional<Admin> byUsername = adminRepository.findByUsername(admin.getUsername());
        if(byUsername.isPresent()){
            Admin admin1 = byUsername.get();
            if(admin1.getPassword().equals(admin.getPassword())) {
                admin1.setPassword((null));
                return ResponseEntity.ok(admin1);
            }
            return ResponseEntity.status(401).body("Invalid username Password");
        }

        return ResponseEntity.status(401).body("Invalid username Password");
    }

        }

