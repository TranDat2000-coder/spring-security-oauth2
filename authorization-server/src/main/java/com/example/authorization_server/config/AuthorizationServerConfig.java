package com.example.authorization_server.config;

import com.example.authorization_server.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;

import java.util.stream.Collectors;

@Configuration
public class AuthorizationServerConfig {
    
    @Autowired
    private ClientRepository clientRepository;

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        // Logic to load clients from the database
        return new InMemoryRegisteredClientRepository(
                clientRepository.findAll().stream().map(client -> RegisteredClient
                        .withId(client.getId().toString())
                        .clientId(client.getClientId())
                        .clientSecret(new BCryptPasswordEncoder().encode(client.getClientSecret()))
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                        .redirectUri(client.getRedirectUri())
                        .scope(client.getScopes())
                        .build()
                ).collect(Collectors.toList())
        );
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }
}
