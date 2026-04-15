package com.example.projectBackend.Controller;

import com.example.projectBackend.Entity.Feedback;
import com.example.projectBackend.Services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {
    @Autowired
    private FeedbackService  service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Feedback feedback){
        return service.create(feedback);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> all(){
        return   service.findAll();
    }
}

