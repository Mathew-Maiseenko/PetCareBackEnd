package com.example.petcare.repository;

import com.example.petcare.entity.Reviews;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {
}
