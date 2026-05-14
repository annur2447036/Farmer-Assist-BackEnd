package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.ProductDTO;
import com.example.projectBackend.Entity.Product;
import com.example.projectBackend.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService services;

    public ProductController(ProductService services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductDTO dto) {
        return services.create(dto);
    }

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

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String keyword) {
        return services.searchProducts(keyword);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return services.getById(id);
    }

    @GetMapping("/farmer/{id}")
    public ResponseEntity<?> getByFarmerId(@PathVariable Long id) {
        return services.getByFarmerId(id);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getByCat_id(@PathVariable Long id) {
        return services.getByCat_Id(id);
    }


    @GetMapping("/total-products/{id}")
    public ResponseEntity<?> getTotalProducts(@PathVariable Long id){

        return services.getTotalProducts(id);

    }
}
