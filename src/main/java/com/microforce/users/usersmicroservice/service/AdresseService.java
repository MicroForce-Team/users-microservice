package com.microforce.users.usersmicroservice.service;

import com.microforce.users.usersmicroservice.entities.Adresse;
import java.util.List;
import java.util.UUID;

public interface AdresseService {
    Adresse createAdresse(Adresse adresse);
    Adresse getAdresseById(UUID id);
    List<Adresse> getAllAdresses();
    Adresse updateAdresse(UUID id, Adresse adresse);
    void deleteAdresse(UUID id);
}