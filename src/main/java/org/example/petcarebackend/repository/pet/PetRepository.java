package org.example.petcarebackend.repository.pet;

import org.example.petcarebackend.model.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
