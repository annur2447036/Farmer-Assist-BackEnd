package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {

  List<Product> findByFarmer_Id(Long id);

  List<Product> findByCategory_Id(Long id);

  @Query("SELECT p FROM Product p WHERE LOWER(p.product_name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
  List<Product> findByProductNameContainingIgnoreCase(@Param("keyword") String keyword);

}
