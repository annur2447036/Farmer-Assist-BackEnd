package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {
  List<Product> findByFarmer_Id(Long id);


}
