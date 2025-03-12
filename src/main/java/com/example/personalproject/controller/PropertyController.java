package com.example.personalproject.controller;

import com.example.personalproject.entity.Property;
import com.example.personalproject.entity.Category;
import com.example.personalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return ResponseEntity.ok(propertyService.createProperty(property));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        property.setId(id);
        return ResponseEntity.ok(propertyService.updateProperty(property));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Property>> getPropertiesByCity(@PathVariable String city) {
        return ResponseEntity.ok(propertyService.findByCity(city));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Property>> getPropertiesByCategory(@PathVariable Category category) {
        return ResponseEntity.ok(propertyService.findByCategory(category));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Property>> getPropertiesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(propertyService.findByUserId(userId));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Property>> getActiveProperties() {
        return ResponseEntity.ok(propertyService.findActiveProperties());
    }
} 