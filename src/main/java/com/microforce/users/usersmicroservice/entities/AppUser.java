package com.microforce.users.usersmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microforce.users.usersmicroservice.entities.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Data
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Override
    public String getUsername() {
        return email;
    }
    // This method from UserDetails -> Return the password
    @Override
    public String getPassword() {
        return password;
    }

    // Set the hashed/bcrypt password
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // === Methods from UserDetails interface ===

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // We can return a collection of authorities based on the role's name
        // e.g., "ROLE_USER", "ROLE_ADMIN"
        return Collections.singleton(() -> "ROLE_" + role.name());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;  // or implement logic if you have an "expired" field
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;  // or implement logic if you have a "locked" field
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // or implement logic if you want to expire credentials
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;  // or implement logic if you have an "enabled" field
    }
}