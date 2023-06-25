package com.spring.petabyte.controller;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.user.UserRegisterDto;
import com.spring.petabyte.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto<?>> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.ok(ResponseDto.success(userService.registerUser(userRegisterDto)));
    }

}