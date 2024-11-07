package com.marcelo721.payment_system.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(@Email
                           String email,
                           @NotBlank
                           String password) {
}
