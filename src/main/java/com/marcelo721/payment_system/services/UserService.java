package com.marcelo721.payment_system.services;

import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.repositories.UserRepository;
import com.marcelo721.payment_system.services.exceptions.EmailUniqueViolationException;
import com.marcelo721.payment_system.services.exceptions.EntityNotFoundException;
import com.marcelo721.payment_system.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
    public User registerUser(User user) {

        try {
            String passwordEncoded = passwordEncoder.encode(user.getPassword());
            user.setPassword(passwordEncoded);

            String randomCode = UserUtil.generateRandomString(64);
            user.setVerificationCode(randomCode);
            user.setEnabled(false);


            return userRepository.save(user);

        } catch (DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException
                    (String.format("Email {%s} already registered ", user.getEmail()));

        }
    }

    @Transactional(readOnly = true)
    public User findById(long id) {

        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow((() -> new EntityNotFoundException("User Not Found")));
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
