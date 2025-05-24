package com.example.authorization_server.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrationUserRequest {

    @NotNull(message = "username is mandatory!")
    @NotEmpty(message = "username is not empty!")
    private String username;

    private String email;

    @NotNull(message = "password is mandatory!")
    @NotEmpty(message = "password is not empty!")
    private String password;

    @NotNull(message = "fullName is mandatory!")
    @NotEmpty(message = "fullName is not empty!")
    private String fullName;

    @NotNull(message = "roles is mandatory!")
    @NotEmpty(message = "roles is not empty!")
    private String roleName;
}
