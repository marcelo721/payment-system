package com.marcelo721.payment_system.services;

import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.repositories.UserRepository;
import com.marcelo721.payment_system.services.exceptions.EmailUniqueViolationException;
import com.marcelo721.payment_system.services.exceptions.EntityNotFoundException;
import com.marcelo721.payment_system.services.exceptions.PasswordInvalidException;
import com.marcelo721.payment_system.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User saveUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailUniqueViolationException(
                    String.format("Email {%s} already registered ", user.getEmail()));
        }

        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        String randomCode = UserUtil.generateRandomString(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(long id) {

        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow((() -> new EntityNotFoundException("User Not Found")));
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updatePassword(String currentPassword, String newPassword, String confirmNewPassword, long id) {

        if (!newPassword.equals(confirmNewPassword)) {
            throw new PasswordInvalidException("the confirmation passwords are different");
        }

        User user = findById(id);

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new PasswordInvalidException("The password is wrong");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return user;
    }
}
