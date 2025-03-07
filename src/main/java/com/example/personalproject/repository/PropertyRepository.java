package com.example.personalproject.repository;

import com.example.personalproject.entity.Property;
import com.example.personalproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByCity(String city);
    List<Property> findByCategory(Category category);
    List<Property> findByUserId(Long userId);
    List<Property> findByIsActiveTrue();
} 