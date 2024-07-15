package com.example.authorization_server.service;

import com.example.authorization_server.model.UserPrincipal;
import com.example.authorization_server.request.AuthRequest;
import com.example.authorization_server.response.JWTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<JWTResponse> authenticateGetToken(AuthRequest authRequest){

        Authentication authManager = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authManager);
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String resultToken = jwtService.generateToken(authManager);

        return ResponseEntity.ok(new JWTResponse(
                userPrincipal.getId(),
                resultToken,
                userPrincipal.getUsername(),
                userPrincipal.getRoles()
        ));
    }
}
