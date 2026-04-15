package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Customer;
import com.example.projectBackend.Entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry,Long> {
}
