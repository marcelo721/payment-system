package com.marcelo721.payment_system.configuration;


import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
    }
}
