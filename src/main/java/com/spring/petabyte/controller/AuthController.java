package com.spring.petabyte.controller;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.user.LoginRequest;
import com.spring.petabyte.dto.user.UserDto;
import com.spring.petabyte.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<UserDto>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(ResponseDto.success(authService.login(loginRequest)));
    }

}
