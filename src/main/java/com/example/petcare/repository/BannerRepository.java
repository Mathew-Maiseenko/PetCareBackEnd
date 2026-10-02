package com.example.petcare.repository;

import com.example.petcare.entity.Banner;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, UUID> {
}
