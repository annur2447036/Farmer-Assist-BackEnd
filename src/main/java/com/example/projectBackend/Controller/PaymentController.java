package com.example.projectBackend.Controller;


import com.example.projectBackend.DTO.OrderRequestDTO;
import com.example.projectBackend.DTO.PaymentRequestDTO;
import com.example.projectBackend.Services.OrderService;
import com.example.projectBackend.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private  PaymentService paymentService;



    @PostMapping
    public ResponseEntity<?> makePayment(@RequestBody PaymentRequestDTO dto){

        return paymentService.savePayment(dto);
    }

    @PostMapping("/create-session/{orderId}")
    public Map<String,String> createCheckouSession(@PathVariable Long orderId) throws Exception{
        return paymentService.createStripeSession(orderId);
    }

    @GetMapping("/confirm")
    public Object confirm(@RequestParam String sessionId){
        return  paymentService.confirmPayment(sessionId);
    }

}






