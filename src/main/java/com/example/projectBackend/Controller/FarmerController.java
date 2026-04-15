package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.LoginRequest;
import com.example.projectBackend.Entity.Admin;
import com.example.projectBackend.Entity.Farmer;
import com.example.projectBackend.Services.FarmerSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/farmer")
@CrossOrigin(origins = "*")
public class FarmerController {
    @Autowired
    private FarmerSevices services;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Farmer farmer){
        return services.create(farmer);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){
        return services.login(loginRequest);
    }
}

