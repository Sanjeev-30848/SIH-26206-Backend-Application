package com.klef.sih.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klef.sih.dto.LoginRequest;
import com.klef.sih.dto.LoginResponse;
import com.klef.sih.dto.RegisterRequest;
import com.klef.sih.dto.UserResponse;
import com.klef.sih.entity.User;
import com.klef.sih.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController 
{

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request) {

        User user = authService.register(request);

        UserResponse response = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        User user = authService.login(request);

        LoginResponse response = new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                null
        );

        return ResponseEntity.ok(response);
    }
}