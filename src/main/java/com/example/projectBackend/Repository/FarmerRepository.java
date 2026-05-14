package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Admin;
import com.example.projectBackend.Entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Long> {
    Optional<Farmer> findByEmail(String email);



}
