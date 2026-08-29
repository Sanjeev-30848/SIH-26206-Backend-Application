package com.klef.sih.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.sih.dto.LoginRequest;
import com.klef.sih.dto.RegisterRequest;
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
    public ResponseEntity<User> register(
            @RequestBody RegisterRequest request) {

        User user = authService.register(request);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(
            @RequestBody LoginRequest request) {

        User user = authService.login(request);

        return ResponseEntity.ok(user);
    }
}