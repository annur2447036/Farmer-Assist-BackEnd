package com.example.projectBackend.Controller;

import com.example.projectBackend.Entity.Admin;
import com.example.projectBackend.Services.AdminServices;
import org.hibernate.metamodel.internal.AbstractDynamicMapInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminServices adminServices;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Admin admin){
        return adminServices.create(admin);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody Admin admin){
        return adminServices.login(admin);
    }


}
