package com.microforce.users.usersmicroservice.web.rest;


import com.microforce.users.usersmicroservice.entities.Adresse;
import com.microforce.users.usersmicroservice.service.AdresseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @PostMapping
    public ResponseEntity<Adresse> createAdresse(@RequestBody Adresse adresse) {
        Adresse created = adresseService.createAdresse(adresse);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adresse> getAdresseById(@PathVariable UUID id) {
        Adresse adresse = adresseService.getAdresseById(id);
        return ResponseEntity.ok(adresse);
    }

    @GetMapping
    public ResponseEntity<List<Adresse>> getAllAdresses() {
        List<Adresse> adresses = adresseService.getAllAdresses();
        return ResponseEntity.ok(adresses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adresse> updateAdresse(@PathVariable UUID id, @RequestBody Adresse adresse) {
        Adresse updated = adresseService.updateAdresse(id, adresse);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable UUID id) {
        adresseService.deleteAdresse(id);
        return ResponseEntity.noContent().build();
    }
}
