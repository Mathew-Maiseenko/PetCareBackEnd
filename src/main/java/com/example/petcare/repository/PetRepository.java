package com.example.petcare.repository;

import com.example.petcare.entity.Pet;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, UUID> {

    List<Pet> findByOwnerUserId(UUID ownerId);
}
