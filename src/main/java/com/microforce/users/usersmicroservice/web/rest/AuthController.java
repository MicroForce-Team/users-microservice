package com.microforce.users.usersmicroservice.web.rest;

import com.microforce.users.usersmicroservice.DTO.AuthResponse;
import com.microforce.users.usersmicroservice.entities.AppUser;
import com.microforce.users.usersmicroservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AppUser appUser) {
        AuthResponse response = authService.login(appUser.getEmail(), appUser.getPassword());
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(authService.register(appUser));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody String refreshToken) {
        // e.g. pass JSON: { "refreshToken": "some-token" } or just the token string
        AuthResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }


}
