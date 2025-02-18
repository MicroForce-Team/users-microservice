package com.microforce.users.usersmicroservice.Repository;

import com.microforce.users.usersmicroservice.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AdresseRepository extends JpaRepository<Adresse, UUID> {
}
