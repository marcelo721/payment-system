package com.marcelo721.payment_system.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.marcelo721.payment_system.entities.User;
import com.marcelo721.payment_system.jwt.JwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public JwtToken generateToken(User user) {

        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("auth")
                    .withSubject(user.getEmail()).withExpiresAt(ExpitarionDate())
                    .sign(algorithm);

            return new JwtToken(token);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("token não foi gerado");
        }
    }

    private Instant ExpitarionDate() {
        return LocalDateTime.now().plusMinutes(1).toInstant(ZoneOffset.of("03:00"));
    }

    public String validateToken(JwtToken jwtToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("auth")
                    .build()
                    .verify(jwtToken.getToken())
                    .getSubject();
        }catch (JWTVerificationException exception){
            throw new RuntimeException("invalid token");
        }
    }
}
