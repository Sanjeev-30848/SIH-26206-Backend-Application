package com.klef.sih.service;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.LoginRequest;
import com.klef.sih.dto.LoginResponse;
import com.klef.sih.dto.RegisterRequest;
import com.klef.sih.entity.Role;
import com.klef.sih.entity.User;
import com.klef.sih.repository.UserRepository;
import com.klef.sih.security.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService 
{

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserRepository userRepository,
            JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }
    
    @Override
    public User register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException(
                    "User already exists with email: " + request.getEmail());
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException(
                        "Invalid email or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException(
                    "Invalid email or password");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                token
        );
    }
}