package com.example.petcare.repository;

import com.example.petcare.entity.PetCharacteristic;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetCharacteristicRepository extends JpaRepository<PetCharacteristic, UUID> {
}
