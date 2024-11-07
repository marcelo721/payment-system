package com.marcelo721.payment_system.components;


import com.marcelo721.payment_system.jwt.JwtToken;
import com.marcelo721.payment_system.repositories.UserRepository;
import com.marcelo721.payment_system.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {


    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        JwtToken token = this.recoverToken(request);
        UsernamePasswordAuthenticationToken authentication = null;
        if (null != token.getToken()) {
            var subject = tokenService.validateToken(token);
            UserDetails user = userRepository.findByEmail(subject);

            authentication = new UsernamePasswordAuthenticationToken(user, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);

    }

    private JwtToken recoverToken(HttpServletRequest request) {

        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;
        } else {
            return new JwtToken(authHeader.replace("Bearer ", ""));
        }
    }
}
