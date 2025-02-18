package com.microforce.users.usersmicroservice.service.Impl;

import com.microforce.users.usersmicroservice.Repository.AdresseRepository;
import com.microforce.users.usersmicroservice.entities.Adresse;
import com.microforce.users.usersmicroservice.service.AdresseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse getAdresseById(UUID id) {
        return adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse not found"));
    }

    @Override
    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    @Override
    public Adresse updateAdresse(UUID id, Adresse adresse) {
        Adresse existingAdresse = getAdresseById(id);
        existingAdresse.setStreet(adresse.getStreet());
        existingAdresse.setCity(adresse.getCity());
        existingAdresse.setPostalCode(adresse.getPostalCode());
        existingAdresse.setCountry(adresse.getCountry());
        // Optionally update the user association if needed.
        return adresseRepository.save(existingAdresse);
    }

    @Override
    public void deleteAdresse(UUID id) {
        adresseRepository.deleteById(id);
    }
}