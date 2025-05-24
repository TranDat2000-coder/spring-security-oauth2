package com.example.authorization_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ROLE")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "ROLE_NAME")
    private String roleName;
}
