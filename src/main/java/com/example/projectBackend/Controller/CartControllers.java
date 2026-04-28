package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.CartDTO;
import com.example.projectBackend.Entity.Cart;
import com.example.projectBackend.Services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")


public class CartControllers {

    @Autowired
    private CartServices cartService;



    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody CartDTO dto){
        return cartService.add(dto);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Cart>> getCart(@PathVariable Long customerId){
        return cartService.getCartByCustomer(customerId);
    }

    @ PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody CartDTO dto){
        return cartService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cartService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clear/customer/{id}")
    public ResponseEntity<Void> clearCart(@PathVariable Long id){
        cartService.clearCart(id);
        return ResponseEntity.ok().build();
    }


}
