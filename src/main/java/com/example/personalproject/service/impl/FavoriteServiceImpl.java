package com.example.personalproject.service.impl;

import com.example.personalproject.entity.Favorite;
import com.example.personalproject.entity.User;
import com.example.personalproject.entity.Property;
import com.example.personalproject.repository.FavoriteRepository;
import com.example.personalproject.repository.UserRepository;
import com.example.personalproject.repository.PropertyRepository;
import com.example.personalproject.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, 
                             UserRepository userRepository,
                             PropertyRepository propertyRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Favorite addToFavorites(Long userId, Long propertyId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setProperty(property);
        
        return favoriteRepository.save(favorite);
    }

    @Override
    public void removeFromFavorites(Long userId, Long propertyId) {
        favoriteRepository.findAll().stream()
                .filter(f -> f.getUser().getId().equals(userId) && 
                           f.getProperty().getId().equals(propertyId))
                .findFirst()
                .ifPresent(favorite -> favoriteRepository.delete(favorite));
    }

    @Override
    public List<Favorite> getUserFavorites(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    @Override
    public boolean isPropertyFavorited(Long userId, Long propertyId) {
        return favoriteRepository.existsByUserIdAndPropertyId(userId, propertyId);
    }
} 