package com.example.personalproject.controller;

import com.example.personalproject.entity.Favorite;
import com.example.personalproject.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "*")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/{userId}/{propertyId}")
    public ResponseEntity<Favorite> addToFavorites(@PathVariable Long userId, @PathVariable Long propertyId) {
        return ResponseEntity.ok(favoriteService.addToFavorites(userId, propertyId));
    }

    @DeleteMapping("/{userId}/{propertyId}")
    public ResponseEntity<Void> removeFromFavorites(@PathVariable Long userId, @PathVariable Long propertyId) {
        favoriteService.removeFromFavorites(userId, propertyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getUserFavorites(@PathVariable Long userId) {
        return ResponseEntity.ok(favoriteService.getUserFavorites(userId));
    }

    @GetMapping("/check/{userId}/{propertyId}")
    public ResponseEntity<Boolean> isPropertyFavorited(@PathVariable Long userId, @PathVariable Long propertyId) {
        return ResponseEntity.ok(favoriteService.isPropertyFavorited(userId, propertyId));
    }
} 