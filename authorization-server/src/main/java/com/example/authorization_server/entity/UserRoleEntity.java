package com.example.authorization_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_ROLE")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;

    private String roleId;
}
