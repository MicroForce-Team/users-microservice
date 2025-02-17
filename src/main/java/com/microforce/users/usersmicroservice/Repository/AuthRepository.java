package com.microforce.users.usersmicroservice.Repository;

import com.microforce.users.usersmicroservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser> findByEmail(String email) ;
}
