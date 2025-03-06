package com.example.personalproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;
    
    // Location fields
    private String city;
    private String district;
    private String street;
    private String address;
    
    @Enumerated(EnumType.STRING)
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Date fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        isActive = true;
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
} 