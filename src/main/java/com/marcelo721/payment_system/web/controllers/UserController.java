package com.marcelo721.payment_system.web.controllers;

import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.services.UserService;
import com.marcelo721.payment_system.web.dto.UserCreateDto;
import com.marcelo721.payment_system.web.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserCreateDto userCreateDto){

        User obj = userCreateDto.toUser();
        userService.registerUser(obj);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toDto(obj));
    }
}
