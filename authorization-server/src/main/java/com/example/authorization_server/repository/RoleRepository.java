package com.example.authorization_server.repository;

import com.example.authorization_server.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {

    Optional<RoleEntity> findByRoleName(String roleName);
}
