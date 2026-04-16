package com.example.projectBackend.Services;

import com.example.projectBackend.DTO.ProductDTO;
import com.example.projectBackend.DTO.SpecificationDTO;
import com.example.projectBackend.Entity.Category;
import com.example.projectBackend.Entity.Product;
import com.example.projectBackend.Entity.ProductImage;
import com.example.projectBackend.Entity.ProductSpecification;
import com.example.projectBackend.Repository.CategoryRepository;
import com.example.projectBackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private  ProductRepository repo;
    @Autowired
    private CategoryRepository categoryRepository;


    public ResponseEntity<?> create(ProductDTO dto){
        Product product = new Product();
        product.setProduct_name(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setAvailable(dto.getAvailable()!=null?dto.getAvailable():true);
        Optional<Category> byIdCategory = categoryRepository.findById(dto.getId());
        if(byIdCategory.isPresent()){
            Category category = byIdCategory.get();
            product.setCategory(category);
        }
        else {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        //productImage
        if(dto.getImageurls() != null){
            boolean isFirst = true;

            for(String imgUrl: dto.getImageurls()){
                ProductImage img = new ProductImage();
                img.setImageUrl(imgUrl);
                img.setProduct(product);
                img.setPrimary(isFirst);
                isFirst=false;
                product.getImages().add(img);
            }
        }
        //productSpecification
        if(dto.getSpecifications() != null){
            for(SpecificationDTO s:dto.getSpecifications()){
                ProductSpecification specification = new ProductSpecification();
                specification.setName(s.getName());
                specification.setValue(s.getValue());
                specification.setProduct(product);
                product.getSpecifications().add(specification);
            }
        }

        Product save = repo.save(product);

        return ResponseEntity.ok(save);
    }

    public ResponseEntity<?> update(Long id,ProductDTO dto){
        Optional<Product> byId = repo.findById(id);
        if(byId.isPresent()){
            Product product = byId.get();
            product.setProduct_name(dto.getName());
            product.setPrice(dto.getPrice());
            product.setStock(dto.getStock());
            product.setAvailable(dto.getAvailable()!=null?dto.getAvailable():true);

            Optional<Category> byIdCategory = categoryRepository.findById(dto.getId());
            if(byIdCategory.isPresent()){
                Category category = byIdCategory.get();
                product.setCategory(category);
            }
            else {
                return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
            }

            //productImage
            if(dto.getImageurls() !=null && !dto.getImageurls().isEmpty()){
                product.getImages().clear();

                boolean isPrimary=true;
                for(String imgUrl:dto.getImageurls()){
                    ProductImage img = new ProductImage();
                    img.setImageUrl(img.getImageUrl());
                    img.setProduct(product);
                    img.setPrimary(isPrimary);
                    isPrimary=false;
                    product.getImages().add(img);
                }
            }

            //productSpecification
            if(dto.getSpecifications() !=null){
                product.getSpecifications().clear();
                for(SpecificationDTO s:dto.getSpecifications()){
                    ProductSpecification specification = new ProductSpecification();
                    specification.setName(s.getName());
                    specification.setValue(s.getValue());
                    specification.setProduct(product);
                    product.getSpecifications().add(specification);
                }
            }

            Product updated = repo.save(product);
            return ResponseEntity.ok(updated);
        }

        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> delete(Long id){
        Optional<Product> byId = repo.findById(id);
        if(byId.isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>("Data deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> all = repo.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    public ResponseEntity<?> getById(Long id){
        Optional<Product> byId = repo.findById(id);
        if(byId.isPresent()){
            Product product = byId.get();
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }
}
