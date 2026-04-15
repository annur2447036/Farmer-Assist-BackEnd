package com.example.projectBackend.Services;

import com.example.projectBackend.Entity.Category;
import com.example.projectBackend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repo;

    public Category createCategory(Category category) {
        if (category.getName()!=null && repo.existsByName(category.getName())){
            throw new RuntimeException("Category already exist");
        }

        return repo.save(category);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }
    public Category findbyId(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("category not found"));

    }


    public Category updateCategory(Long id, Category category) {
        Category existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        existing.setName(category.getName());
        existing.setImageurl(category.getImageurl());

        return repo.save(existing);
    }

//    public void deleteCategory(Long id) {
//        if (repo.existsById(id)) {
//            repo.deleteById(id);
//        } else {
//            throw new RuntimeException("Category Not Found");
//        }

        public ResponseEntity<?>delete(Long id){
            Optional<Category> byid=repo.findById(id);
        if (byid.isPresent()){
            repo.deleteById(id);
            return ResponseEntity.ok(Map.of("message","Record Deleted"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message","Category not found"));
  }


}