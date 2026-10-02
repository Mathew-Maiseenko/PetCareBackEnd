package com.example.petcare.repository;

import com.example.petcare.entity.Booking;
import com.example.petcare.entity.enums.BookingStatus;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    List<Booking> findByMasterIdAndStatus(UUID masterId, BookingStatus status);
}
