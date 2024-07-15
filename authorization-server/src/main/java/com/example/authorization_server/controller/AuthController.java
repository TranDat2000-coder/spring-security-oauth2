package com.example.authorization_server.controller;

import com.example.authorization_server.request.AuthRequest;
import com.example.authorization_server.service.AuthService;
import com.example.authorization_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(AuthRequest authRequest){
        return authService.authenticateGetToken(authRequest);
    }
}
