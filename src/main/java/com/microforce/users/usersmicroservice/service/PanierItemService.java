package com.microforce.users.usersmicroservice.service;

import com.microforce.users.usersmicroservice.entities.PanierItem;
import java.util.List;
import java.util.UUID;

public interface PanierItemService {
    PanierItem createPanierItem(PanierItem panierItem);
    PanierItem getPanierItemById(UUID id);
    List<PanierItem> getAllPanierItems();
    PanierItem updatePanierItem(UUID id, PanierItem panierItem);
    void deletePanierItem(UUID id);
}
