package com.spring.petabyte.service;

import com.spring.petabyte.dto.user.LoginRequest;
import com.spring.petabyte.dto.user.UserDto;

public interface AuthService {
    UserDto login(LoginRequest loginRequest);
}