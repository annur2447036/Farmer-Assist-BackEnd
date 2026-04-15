package com.example.projectBackend.Controller;
import com.example.projectBackend.Entity.Enquiry;
import com.example.projectBackend.Services.EnquiryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/enquiry")
@CrossOrigin(origins = "*")

public class EnquiryController {


    @Autowired
    public EnquiryServices services;

    @PostMapping
    public ResponseEntity<Enquiry> save(@RequestBody Enquiry enquiry){
        Enquiry saveEnquiry = services.Create(enquiry);
        return  new ResponseEntity<>(saveEnquiry, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<java.util.List<Enquiry>> getAll() {
        java.util.List<Enquiry> list = services.getAllEnquiry();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enquiry>update(@PathVariable Long id,@RequestBody Enquiry enquiry){

        Enquiry updateEnq= services.updateEnquiry(id,enquiry);
        return new ResponseEntity<>(updateEnq,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        services.deleteEnquiry(id);
        return new ResponseEntity<>("Enquiry Deleted Successfully", HttpStatus.OK);
    }


}
