package com.example.petcare.repository;

import com.example.petcare.entity.Notification;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    long countByUserIdAndIsReadFalse(UUID userId);
}
