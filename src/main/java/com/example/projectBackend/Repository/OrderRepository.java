package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomer_Id(Long customerId);

    @Query("SELECT DISTINCT o.shipping.city FROM Order o")
    List<String> findDistinctCities();

    List<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);

    List<Order> findByShippingCityIgnoreCase(String city);

    List<Order> findByOrderDateBetweenAndShippingCityIgnoreCase(
            LocalDateTime start,LocalDateTime end,String city
    );


}
