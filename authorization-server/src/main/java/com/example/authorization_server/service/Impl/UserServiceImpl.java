package com.example.authorization_server.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userDetail = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));

//        return UserPrincipal.build(userDetail);
        return null;
    }

    @Override
    public UserEntity registrationUser(RegistrationUserRequest request) {
        log.info("Registration user: {} {}", getClass(), request);

        if (findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameNotFoundException("Username already exists: " + request.getUsername());
        }

        RoleEntity role = roleRepository.findByRoleName(request.getRoleName())
                .orElseThrow(() -> new BusinessException(ErrorCode.SUCCESS));

        return null;
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
