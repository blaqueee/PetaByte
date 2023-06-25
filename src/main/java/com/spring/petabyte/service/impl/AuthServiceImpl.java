package com.spring.petabyte.service.impl;

import com.spring.petabyte.configuration.JwtUtils;
import com.spring.petabyte.dto.user.LoginRequest;
import com.spring.petabyte.dto.user.UserDto;
import com.spring.petabyte.entity.User;
import com.spring.petabyte.mapper.UserMapper;
import com.spring.petabyte.repository.UserRepository;
import com.spring.petabyte.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public UserDto login(LoginRequest loginRequest) {
        Authentication auth = authenticate(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtUtils.generateJwtToken(auth);
        User user = (User) auth.getPrincipal();
        return userMapper.toDto(user, token);
    }

    private Authentication authenticate(LoginRequest loginRequest) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
    }
}
