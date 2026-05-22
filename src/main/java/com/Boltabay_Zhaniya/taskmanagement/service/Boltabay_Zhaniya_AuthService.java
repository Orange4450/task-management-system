package com.Boltabay_Zhaniya.taskmanagement.service;
import com.Boltabay_Zhaniya.taskmanagement.dto.*;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_Role;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_User;
import com.Boltabay_Zhaniya.taskmanagement.repository.Boltabay_Zhaniya_RoleRepository;
import com.Boltabay_Zhaniya.taskmanagement.repository.Boltabay_Zhaniya_UserRepository;
import com.Boltabay_Zhaniya.taskmanagement.security.Boltabay_Zhaniya_JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class Boltabay_Zhaniya_AuthService {

    private static final Logger logger =
            LoggerFactory.getLogger(Boltabay_Zhaniya_AuthService.class);

    private final Boltabay_Zhaniya_UserRepository userRepository;

    private final Boltabay_Zhaniya_RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final Boltabay_Zhaniya_JwtUtil jwtUtil;

    public void register(Boltabay_Zhaniya_RegisterRequestDto dto) {

        logger.info("Registering new user");

        Boltabay_Zhaniya_Role role = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {

                    logger.info("Creating ROLE_USER");

                    Boltabay_Zhaniya_Role newRole = new Boltabay_Zhaniya_Role();

                    newRole.setName("ROLE_USER");

                    return roleRepository.save(newRole);
                });

        Boltabay_Zhaniya_User user = new Boltabay_Zhaniya_User();

        user.setUsername(dto.getUsername());

        user.setEmail(dto.getEmail());

        user.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );

        user.setRole(role);

        userRepository.save(user);

        logger.info(
                "User registered successfully with email: {}",
                dto.getEmail()
        );
    }

    public Boltabay_Zhaniya_AuthResponseDto login(Boltabay_Zhaniya_LoginRequestDto dto) {

        logger.info("User login attempt: {}", dto.getEmail());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        String token = jwtUtil.generateToken(dto.getEmail());

        logger.info("JWT token generated successfully");

        return new Boltabay_Zhaniya_AuthResponseDto(token);
    }
}