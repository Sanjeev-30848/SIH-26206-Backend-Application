package com.klef.sih.service;

import com.klef.sih.dto.LoginRequest;
import com.klef.sih.dto.RegisterRequest;
import com.klef.sih.entity.User;

public interface AuthService
{

    User register(RegisterRequest request);

    User login(LoginRequest request);
}