package com.microforce.users.usersmicroservice.service;

import com.microforce.users.usersmicroservice.DTO.AuthResponse;
import com.microforce.users.usersmicroservice.Repository.AuthRepository;
import com.microforce.users.usersmicroservice.config.JwtService;
import com.microforce.users.usersmicroservice.entities.AppUser;
import com.microforce.users.usersmicroservice.entities.enums.Role;
import com.microforce.users.usersmicroservice.web.error.AuthException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;

    public AuthService(AuthRepository authRepository, JwtService jwtService) {
        this.authRepository = authRepository;
        this.jwtService = jwtService;
    }

    public AppUser register(AppUser appUser) {
        if (authRepository.findByEmail(appUser.getEmail()).isPresent()) {
            throw new AuthException("Email already exists");
        }

        // Set a default role using your enum (e.g., CUSTOMER)
        appUser.setRole(Role.CUSTOMER);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        return authRepository.save(appUser);
    }

    public AuthResponse login(String email, String rawPassword) {
        AppUser appUser = authRepository.findByEmail(email)
                .orElseThrow(() -> new AuthException("Email not found"));

        if (!passwordEncoder.matches(rawPassword, appUser.getPassword())) {
            throw new AuthException("Invalid credentials!");
        }

        String accessToken = jwtService.generateAccessToken(appUser);
        String refreshToken = jwtService.generateRefreshToken(appUser);

        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse refreshToken(String refreshToken) {
        if (!jwtService.validateToken(refreshToken)) {
            throw new AuthException("Invalid refresh token!");
        }

        String email = jwtService.getEmailFromToken(refreshToken);

        AppUser appUser = authRepository.findByEmail(email)
                .orElseThrow(() -> new AuthException("User not found for refresh token"));

        String newAccessToken = jwtService.generateAccessToken(appUser);
        String newRefreshToken = jwtService.generateRefreshToken(appUser);

        return new AuthResponse(newAccessToken, newRefreshToken);
    }
}
