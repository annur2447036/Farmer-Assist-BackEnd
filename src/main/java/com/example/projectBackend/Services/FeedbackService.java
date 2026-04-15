package com.example.projectBackend.Services;

import com.example.projectBackend.Entity.Feedback;
import com.example.projectBackend.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    public ResponseEntity<?>create(Feedback feedback){
        Feedback save = repo.save(feedback);
        return new ResponseEntity<>(save, HttpStatus.CREATED);

    }

    public ResponseEntity<List<Feedback>> findAll(){
        List<Feedback> all = repo.findAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
}

