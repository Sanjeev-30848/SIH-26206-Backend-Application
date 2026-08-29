package com.klef.sih.service;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.LoginRequest;
import com.klef.sih.dto.RegisterRequest;
import com.klef.sih.entity.Role;
import com.klef.sih.entity.User;
import com.klef.sih.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService 
{

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException(
                        "Invalid email or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException(
                    "Invalid email or password");
        }

        return user;
    }
}