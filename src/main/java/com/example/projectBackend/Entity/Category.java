package com.example.projectBackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String imageurl;


    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;

    // Default Constructor (Required)
    public Category() {
    }

    // Parameterized Constructor
    public Category(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}