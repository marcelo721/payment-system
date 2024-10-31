package com.marcelo721.payment_system.web.dto;


import com.marcelo721.payment_system.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateDto(
        @NotBlank @Size(min = 8, max = 50, message = "the name must be between 7 and 50 characters ")
        String name,

        @NotBlank @Size(min = 8, max = 8)
        String password,

        @NotBlank @Email @Size(min = 10, max = 100)
        String email) {

    public User toUser() {

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        return user;
    }
}
