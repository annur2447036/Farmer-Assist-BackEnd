package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomer_Id(Long customerId);

}
