package com.example.petcare.repository;

import com.example.petcare.entity.Favorite;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {
}
