package com.example.authorization_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
