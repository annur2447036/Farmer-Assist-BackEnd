package com.example.projectBackend.Services;
import com.example.projectBackend.Entity.Enquiry;
import com.example.projectBackend.Repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnquiryServices {

    @Autowired
    com.example.projectBackend.Repository.EnquiryRepository repo ;

    public Enquiry Create(Enquiry enquiry) {
        return  repo.save(enquiry);

    }

    public List<Enquiry> getAllEnquiry() {
        return repo.findAll();
    }

    public Enquiry updateEnquiry(Long id, Enquiry enquiry) {
        Enquiry exist = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enquiry Not Found"));

        exist.setName(enquiry.getName());
        exist.setEmail(enquiry.getEmail());
        exist.setPassword(enquiry.getPassword());
        exist.setContact(enquiry.getContact());
        exist.setSubject(enquiry.getSubject());
        exist.setMessage(enquiry.getMessage());

        return repo.save(exist);
    }

    public void deleteEnquiry(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }
        else
            throw new RuntimeException("Enquiry not Found");
    }
}
