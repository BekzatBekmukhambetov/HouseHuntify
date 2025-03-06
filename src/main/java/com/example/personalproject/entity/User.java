package com.example.personalproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String phoneNumber;
    private String fullName;
    private Boolean isAgent;
    private String companyName; // for agents
    private LocalDateTime registrationDate;
    private Boolean isActive;
    
    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDateTime.now();
        isActive = true;
    }
} 