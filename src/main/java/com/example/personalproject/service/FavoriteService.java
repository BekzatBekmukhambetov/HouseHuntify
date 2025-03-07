package com.example.personalproject.service;

import com.example.personalproject.entity.Favorite;
import java.util.List;

public interface FavoriteService {
    Favorite addToFavorites(Long userId, Long propertyId);
    void removeFromFavorites(Long userId, Long propertyId);
    List<Favorite> getUserFavorites(Long userId);
    boolean isPropertyFavorited(Long userId, Long propertyId);
} 