package com.marcelo721.payment_system.web.controllers;

import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.services.UserService;
import com.marcelo721.payment_system.web.dto.UserCreateDto;
import com.marcelo721.payment_system.web.dto.UserPasswordDto;
import com.marcelo721.payment_system.web.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserCreateDto userCreateDto){

        User     obj = userCreateDto.toUser();
        userService.saveUser(obj);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toDto(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePassword( @PathVariable Long id,  @Valid @RequestBody UserPasswordDto user){

        log.info("Updating password for user with id: {}", id);
        User obj = userService.updatePassword(user.currentPassword(),user.newPassword(), user.confirmPassword(), id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById( @PathVariable long id){

        log.info("Fetching user with id: {}", id);
        User user = userService.findById(id);

        return ResponseEntity.ok(UserResponseDto.toDto(user));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> findById(){

        log.info("Finding all users");
        List<UserResponseDto> users = UserResponseDto.toListDto(userService.findAllUsers());

        return ResponseEntity.ok(users);
    }
}
