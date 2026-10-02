package com.example.petcare.repository;

import com.example.petcare.entity.PetBreed;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetBreedRepository extends JpaRepository<PetBreed, UUID> {
}
