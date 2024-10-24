package com.marcelo721.payment_system.web.dto;

import com.marcelo721.payment_system.entities.User;

public  record UserResponseDto(String name, String email, Long id) {

    public static UserResponseDto toDto(User user){
        return new UserResponseDto(user.getName(), user.getEmail(), user.getId());
    }
}
