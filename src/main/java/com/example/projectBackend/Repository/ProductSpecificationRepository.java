package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification,Long> {
   List<ProductSpecification> findByProduct(Long productId);
}
