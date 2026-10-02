package com.example.petcare.repository;

import com.example.petcare.entity.BlockedUser;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockedUserRepository extends JpaRepository<BlockedUser, UUID> {
}
