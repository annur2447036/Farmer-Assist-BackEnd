package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart>findByCustomer_Id(Long id);
    void deleteByCustomerId(Long id);
}
