package com.example.projectBackend.DTO;

import java.util.List;

public class ProductDTO {
    private String name;

    private Double price;
    private Integer stock;
    private Boolean available;
    private Long categoryId;//Category Id
    private List<String> imageurls;
    private List<SpecificationDTO> specifications;
    private  Long farmerId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<String> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<String> imageurls) {
        this.imageurls = imageurls;
    }

    public List<SpecificationDTO> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<SpecificationDTO> specifications) {
        this.specifications = specifications;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }
}
