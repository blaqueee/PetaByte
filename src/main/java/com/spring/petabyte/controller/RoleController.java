package com.spring.petabyte.controller;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.role.RoleAddDto;
import com.spring.petabyte.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ResponseDto<?>> create(@Valid RoleAddDto roleDto) {
        return ResponseEntity.ok(roleService.create(roleDto));
    }
}
