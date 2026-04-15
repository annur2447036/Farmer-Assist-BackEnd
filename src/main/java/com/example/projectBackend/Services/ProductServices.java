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

import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repo;

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?>create(ProductDTO dto){
        Product product =new Product();
        product.setProduct_name(dto.getName());;
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setAvailable(dto.getStock()!=null?dto.getAvailable():true);
        Optional<Category> byIdCategory = categoryRepository.findById(dto.getId());

        if(byIdCategory.isPresent()){
            Category category = byIdCategory.get();
            product.setCategory(category);
        }
        else {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        if(dto.getImageurls()!= null){
            boolean isfirst=true;
            for (String imgUrl : dto.getImageurls()){
                ProductImage img =new ProductImage();
                img.setImageUrl(imgUrl);
                img.setProduct(product);
                img.setPrimary(isfirst);
                isfirst=false;
            }

        }
        if(dto.getSpecifications()!=null){
            for(SpecificationDTO sp : dto.getSpecifications()){

                ProductSpecification specification= new ProductSpecification();
                specification.setName(sp.getName());
                specification.setValue(sp.getValue());
                specification.setProduct(product);
                product.getSpecifications().add(specification);

            }
        }
        Product save=repo.save(product);
        return ResponseEntity.ok(save);


    }
}
