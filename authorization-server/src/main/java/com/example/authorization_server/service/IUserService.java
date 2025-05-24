package com.example.authorization_server.service;

import com.example.authorization_server.entity.UserEntity;
import com.example.authorization_server.request.RegistrationUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {

    UserEntity registrationUser(RegistrationUserRequest request);

    Optional<UserEntity> findByUsername(String username);
}
