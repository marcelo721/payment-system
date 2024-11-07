package com.marcelo721.payment_system.web.controllers;


import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.jwt.JwtToken;
import com.marcelo721.payment_system.services.AuthenticationService;
import com.marcelo721.payment_system.services.TokenService;
import com.marcelo721.payment_system.web.dto.UserLoginDto;
import com.marcelo721.payment_system.web.exceptions.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("api/v1/login")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDto userLoginDto, HttpServletRequest request) {

        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(userLoginDto.email(), userLoginDto.password());

            var auth = authenticationManager.authenticate(usernamePassword);
            JwtToken token = tokenService.generateToken((User) auth.getPrincipal());

            return  ResponseEntity.ok(token.getToken());
        }catch (AuthenticationException e) {
            log.warn("Bad credentials");
        }

        return ResponseEntity.badRequest().body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Credentials"));
    }
}
