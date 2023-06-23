package com.spring.petabyte.service.impl;

import com.spring.petabyte.configuration.JwtUtils;
import com.spring.petabyte.mapper.UserMapper;
import com.spring.petabyte.repository.UserRepository;
import com.spring.petabyte.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


}
