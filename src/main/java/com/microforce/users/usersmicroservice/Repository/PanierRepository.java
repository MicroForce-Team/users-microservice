package com.microforce.users.usersmicroservice.Repository;

import com.microforce.users.usersmicroservice.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PanierRepository extends JpaRepository<Panier, UUID> {
}
