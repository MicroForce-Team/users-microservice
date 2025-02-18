package com.microforce.users.usersmicroservice.service.Impl;

import com.microforce.users.usersmicroservice.Repository.PanierItemRepository;
import com.microforce.users.usersmicroservice.entities.PanierItem;
import com.microforce.users.usersmicroservice.service.PanierItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PanierItemServiceImpl implements PanierItemService {

    private final PanierItemRepository panierItemRepository;

    public PanierItemServiceImpl(PanierItemRepository panierItemRepository) {
        this.panierItemRepository = panierItemRepository;
    }

    @Override
    public PanierItem createPanierItem(PanierItem panierItem) {
        return panierItemRepository.save(panierItem);
    }

    @Override
    public PanierItem getPanierItemById(UUID id) {
        return panierItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PanierItem not found"));
    }

    @Override
    public List<PanierItem> getAllPanierItems() {
        return panierItemRepository.findAll();
    }

    @Override
    public PanierItem updatePanierItem(UUID id, PanierItem panierItem) {
        PanierItem existingItem = getPanierItemById(id);
        existingItem.setProductId(panierItem.getProductId());
        existingItem.setQuantity(panierItem.getQuantity());
        existingItem.setPanier(panierItem.getPanier());
        return panierItemRepository.save(existingItem);
    }

    @Override
    public void deletePanierItem(UUID id) {
        panierItemRepository.deleteById(id);
    }
}
