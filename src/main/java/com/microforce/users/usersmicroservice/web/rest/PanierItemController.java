package com.microforce.users.usersmicroservice.web.rest;

import com.microforce.users.usersmicroservice.entities.PanierItem;
import com.microforce.users.usersmicroservice.service.PanierItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/panier-items")
public class PanierItemController {

    private final PanierItemService panierItemService;

    public PanierItemController(PanierItemService panierItemService) {
        this.panierItemService = panierItemService;
    }

    @PostMapping
    public ResponseEntity<PanierItem> createPanierItem(@RequestBody PanierItem panierItem) {
        PanierItem created = panierItemService.createPanierItem(panierItem);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanierItem> getPanierItemById(@PathVariable UUID id) {
        PanierItem panierItem = panierItemService.getPanierItemById(id);
        return ResponseEntity.ok(panierItem);
    }

    @GetMapping
    public ResponseEntity<List<PanierItem>> getAllPanierItems() {
        List<PanierItem> panierItems = panierItemService.getAllPanierItems();
        return ResponseEntity.ok(panierItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanierItem> updatePanierItem(@PathVariable UUID id, @RequestBody PanierItem panierItem) {
        PanierItem updated = panierItemService.updatePanierItem(id, panierItem);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanierItem(@PathVariable UUID id) {
        panierItemService.deletePanierItem(id);
        return ResponseEntity.noContent().build();
    }
}
