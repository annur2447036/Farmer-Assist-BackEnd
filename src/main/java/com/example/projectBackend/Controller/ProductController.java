package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.ProductDTO;
import com.example.projectBackend.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductServices services;

    @PostMapping
    public ResponseEntity<?>create(@RequestBody ProductDTO dto){
        return services.create(dto);
    }

}
