package com.example.petcare.repository;

import com.example.petcare.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByTelephone(String phone);

    boolean existsByEmail(String email);
}
