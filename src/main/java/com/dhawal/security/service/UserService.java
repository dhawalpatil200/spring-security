package com.dhawal.security.service;

import com.dhawal.security.models.RoleEntity;
import com.dhawal.security.models.UserEntity;
import com.dhawal.security.repository.RolesRepository;
import com.dhawal.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    RolesRepository rolesRepository;

    public UserEntity register(UserEntity user) {
        Optional<RoleEntity> role = rolesRepository.findByName("ROLE_USER");
        if(role.isEmpty()) {
            throw new RuntimeException("User role not found");
        }
        user.setRoles(Collections.singletonList(role.get()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }

    public String verify(UserEntity user) {

        // This will verify users credentials, if wrong credentials then BadCredentialsException will be thrown (status code 401)
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        ));

        // Generate and return JWT token
        return jwtService.generateToken(user.getUsername());
    }
}
