package com.example.projectBackend.Services;

import com.example.projectBackend.DTO.ProductDTO;
import com.example.projectBackend.Entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<?> create(ProductDTO dto);

    ResponseEntity<?> update(Long id, ProductDTO dto);

    ResponseEntity<String> delete(Long id);

    ResponseEntity<List<Product>> getAllProduct();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<List<Product>> getByFarmerId(Long id);

    ResponseEntity<List<Product>> getByCat_Id(Long id);

    ResponseEntity<List<Product>> searchProducts(String keyword);

    ResponseEntity<?>getTotalProducts(Long id);
}
