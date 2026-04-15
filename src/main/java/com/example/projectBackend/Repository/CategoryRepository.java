package com.example.projectBackend.Repository;

import com.example.projectBackend.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    boolean existsByName(String name);
}
