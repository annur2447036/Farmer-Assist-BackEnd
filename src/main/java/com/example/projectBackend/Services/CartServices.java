package com.example.projectBackend.Services;

import com.example.projectBackend.DTO.CartDTO;
import com.example.projectBackend.Entity.Cart;
import com.example.projectBackend.Entity.Customer;
import com.example.projectBackend.Entity.Product;
import com.example.projectBackend.Repository.CartRepository;
import com.example.projectBackend.Repository.CustomerRepository;
import com.example.projectBackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartServices {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?>add(CartDTO dto){
            Cart cart = new Cart();
            Optional<Customer> byId = customerRepository.findById(dto.getCustomerId());
            if(byId.isPresent()){
                Customer customer = byId.get();
                cart.setCustomer(customer);

            }
            else {
                return ResponseEntity.notFound().build();
            }

            Optional<Product> byIdproduct = productRepository.findById(dto.getProductId());
            if(byIdproduct.isPresent()){
                Product product = byIdproduct.get();
                cart.setProduct(product);
            }
            else {
                return ResponseEntity.notFound().build();
            }

            cart.setQuantity(dto.getQuantity());

            cartRepository.save(cart);
            return  ResponseEntity.ok(cart);
        }

    public ResponseEntity<?> update(Long id,CartDTO dto){
        Optional<Cart> byId = cartRepository.findById(id);
        if(byId.isPresent()){
            Cart existing = byId.get();
            existing.setQuantity(dto.getQuantity());
            cartRepository.save(existing);
            return ResponseEntity.ok(existing);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Cart>> getCartByCustomer(Long id){
        List<Cart> items = cartRepository.findByCustomer_Id(id);
        return ResponseEntity.ok(items);
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }


    @Transactional
    public void clearCart(Long customerId){
        cartRepository.deleteByCustomerId(customerId);
    }


}

