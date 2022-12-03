package com.example.communitysystem.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findByUsername(String username);
    boolean existsByUsername(String username);
}
