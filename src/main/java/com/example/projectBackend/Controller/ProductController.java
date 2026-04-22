package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.ProductDTO;
import com.example.projectBackend.Entity.Product;
import com.example.projectBackend.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductServices services;

    @PostMapping
    public ResponseEntity<?>create(@RequestBody ProductDTO dto) {
        System.out.println("Received Product: " + dto);
        System.out.print(dto);
        return services.create(dto);
    }


//
//    @PostMapping
//    public ResponseEntity<?>create(@RequestBody ProductDTO dto) {
//        System.out.println("Received Product: " + dto);
//        return services.create(dto);
//    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return services.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return services.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> all() {
        return services.getAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return services.getById(id);
    }


    @GetMapping("/farmer/{id}")
    public ResponseEntity<?>getByFarmerId(@PathVariable Long id) {
        return services.getByFarmerId(id);


    }
        @GetMapping("/categories/{id}")
        public ResponseEntity<?>getByCat_id(@PathVariable Long id){
            return  services.getByCat_Id(id);
        }

    }


