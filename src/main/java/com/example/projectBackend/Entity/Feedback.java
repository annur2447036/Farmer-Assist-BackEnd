package com.example.projectBackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String email;
    private  Integer mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(Integer productQuality) {
        this.productQuality = productQuality;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(Integer orderProcess) {
        this.orderProcess = orderProcess;
    }

    public Integer getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(Integer deliveryService) {
        this.deliveryService = deliveryService;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private Integer productQuality;
    private Integer productPrice;
    private Integer orderProcess;
    private Integer deliveryService;
    @Column(columnDefinition = "TEXT")
    private String suggestion;
    private LocalDateTime createdAt;

    public Feedback(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.now();
    }
}
