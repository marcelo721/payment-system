package com.marcelo721.payment_system.entities;


import com.marcelo721.payment_system.entities.enums.StatusAccount;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true,name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "enabled")
    private StatusAccount enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}
