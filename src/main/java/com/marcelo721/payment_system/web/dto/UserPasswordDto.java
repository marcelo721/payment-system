package com.marcelo721.payment_system.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserPasswordDto(@NotBlank @Size(min = 8, max = 8)
                              String currentPassword,
                              @NotBlank @Size(min = 8, max = 8)
                              String newPassword,
                              @NotBlank @Size(min = 8, max = 8)
                              String confirmPassword) {
}
