package com.example.authorization_server.repository;

import com.example.authorization_server.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String> {
}
