package com.marcelo721.payment_system.services;

import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
