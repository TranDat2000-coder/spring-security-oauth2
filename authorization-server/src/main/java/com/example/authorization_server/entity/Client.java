package com.example.authorization_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;

    private String clientSecret;

    private String redirectUri;

    private String grantTypes;

    private String scopes;
}
