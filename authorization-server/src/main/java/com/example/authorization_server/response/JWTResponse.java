package com.example.authorization_server.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JWTResponse {

    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JWTResponse(Long id, String token, String username,
                       Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.roles = roles;
    }
}
