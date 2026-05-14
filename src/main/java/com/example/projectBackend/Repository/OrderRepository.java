package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT DISTINCT o FROM Order o JOIN o.items i LEFT JOIN i.product p LEFT JOIN p.farmer f WHERE f.id = :farmerId OR i.farmerId = :farmerId")
    List<Order> findOrdersByFarmerId(@Param("farmerId") Long farmerId);


}
