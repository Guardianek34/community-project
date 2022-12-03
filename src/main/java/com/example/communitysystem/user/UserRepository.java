package com.example.communitysystem.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByName(String name);
}
