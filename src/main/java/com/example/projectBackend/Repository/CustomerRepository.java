package com.example.projectBackend.Repository;


import com.example.projectBackend.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

   Optional <Customer> findByEmail(String email);
}
