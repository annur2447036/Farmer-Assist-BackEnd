package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.OrderRequestDTO;
import com.example.projectBackend.Entity.Order;
import com.example.projectBackend.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")

public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO dto){
        return orderService.placeOrder(dto);
    }

    @GetMapping("/{customerId}/customer")
    public ResponseEntity<?> getOrderByCustomer(@PathVariable Long customerId){
        return orderService.getOrderByCustomer(customerId);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId){
        Order order = orderService.cancleOrder(orderId);
        return ResponseEntity.ok(order);
    }
}
