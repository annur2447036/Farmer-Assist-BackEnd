package com.example.projectBackend.Services;

import com.example.projectBackend.DTO.LoginRequest;
import com.example.projectBackend.Entity.Farmer;
import com.example.projectBackend.Repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmerSevices {

    @Autowired
    private FarmerRepository repo;

    public ResponseEntity<?> create(Farmer farmer) {
        Optional<Farmer> byUserName = repo.findByEmail(farmer.getEmail());
        if (byUserName.isPresent()) {
            return ResponseEntity.badRequest().body("Username Already Existed");
        }
        Farmer save = repo.save(farmer);
        save.setPassword(null);
        return ResponseEntity.ok(save);

    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<Farmer> byUserName = repo.findByEmail(loginRequest.getEmail());
       // System.out.println(byUserName.get());
        if (byUserName.isPresent()){
        Farmer admin1 = byUserName.get();
        if (admin1.getPassword().equals(loginRequest.getPassword())) {
            admin1.setPassword(null);
            return ResponseEntity.ok(admin1);
        }
        return ResponseEntity.status(401).body("Invalid UserName Password ");

    }
        return ResponseEntity.status(401).body("Invalid Usename Password");

}
}

