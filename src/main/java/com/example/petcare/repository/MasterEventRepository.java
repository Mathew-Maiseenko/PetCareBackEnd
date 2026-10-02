package com.example.petcare.repository;

import com.example.petcare.entity.MasterEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterEventRepository extends JpaRepository<MasterEvent, UUID> {

    List<MasterEvent> findByMasterIdAndDateBetween(UUID masterId, LocalDate start, LocalDate end);
}
