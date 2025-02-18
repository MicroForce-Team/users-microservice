package com.microforce.users.usersmicroservice.service;

import com.microforce.users.usersmicroservice.entities.Panier;
import java.util.List;
import java.util.UUID;

public interface PanierService {
    Panier createPanier(Panier panier);
    Panier getPanierById(UUID id);
    List<Panier> getAllPaniers();
    Panier updatePanier(UUID id, Panier panier);
    void deletePanier(UUID id);
}
