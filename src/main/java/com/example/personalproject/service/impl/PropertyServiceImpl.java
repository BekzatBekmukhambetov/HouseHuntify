package com.example.personalproject.service.impl;

import com.example.personalproject.entity.Property;
import com.example.personalproject.entity.Category;
import com.example.personalproject.repository.PropertyRepository;
import com.example.personalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property updateProperty(Property property) {
        if (!propertyRepository.existsById(property.getId())) {
            throw new RuntimeException("Property not found");
        }
        return propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> findByCity(String city) {
        return propertyRepository.findByCity(city);
    }

    @Override
    public List<Property> findByCategory(Category category) {
        return propertyRepository.findByCategory(category);
    }

    @Override
    public List<Property> findByUserId(Long userId) {
        return propertyRepository.findByUserId(userId);
    }

    @Override
    public List<Property> findActiveProperties() {
        return propertyRepository.findByIsActiveTrue();
    }
} 