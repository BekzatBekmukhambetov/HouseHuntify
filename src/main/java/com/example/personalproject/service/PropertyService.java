package com.example.personalproject.service;

import com.example.personalproject.entity.Property;
import com.example.personalproject.entity.Category;
import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);
    Property getPropertyById(Long id);
    List<Property> getAllProperties();
    Property updateProperty(Property property);
    void deleteProperty(Long id);
    
    List<Property> findByCity(String city);
    List<Property> findByCategory(Category category);
    List<Property> findByUserId(Long userId);
    List<Property> findActiveProperties();
} 