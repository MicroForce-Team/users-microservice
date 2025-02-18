package com.microforce.users.usersmicroservice.Repository;

import com.microforce.users.usersmicroservice.entities.PanierItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PanierItemRepository extends JpaRepository<PanierItem, UUID> {
}
