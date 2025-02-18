package com.microforce.users.usersmicroservice.service.Impl;

import com.microforce.users.usersmicroservice.Repository.PanierRepository;
import com.microforce.users.usersmicroservice.entities.Panier;
import com.microforce.users.usersmicroservice.service.PanierService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PanierServiceImpl implements PanierService {

    private final PanierRepository panierRepository;

    public PanierServiceImpl(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    @Override
    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public Panier getPanierById(UUID id) {
        return panierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Panier not found"));
    }

    @Override
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    @Override
    public Panier updatePanier(UUID id, Panier panier) {
        Panier existingPanier = getPanierById(id);
        // Update the user association if needed
        existingPanier.setUser(panier.getUser());
        // For the items, you might want to handle them separately
        existingPanier.setItems(panier.getItems());
        return panierRepository.save(existingPanier);
    }

    @Override
    public void deletePanier(UUID id) {
        panierRepository.deleteById(id);
    }
}
