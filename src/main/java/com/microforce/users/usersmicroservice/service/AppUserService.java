package com.microforce.users.usersmicroservice.service;

import com.microforce.users.usersmicroservice.entities.AppUser;
import java.util.List;
import java.util.UUID;

public interface AppUserService {
    AppUser createUser(AppUser user);
    AppUser getUserById(UUID id);
    List<AppUser> getAllUsers();
    AppUser updateUser(UUID id, AppUser user);
    void deleteUser(UUID id);
}
