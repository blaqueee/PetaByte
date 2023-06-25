package com.spring.petabyte.controller;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.permission.PermissionDto;
import com.spring.petabyte.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ResponseDto<PermissionDto>> create(@Valid @RequestBody PermissionDto permissionDto) {
        return ResponseEntity.ok(ResponseDto.success(permissionService.create(permissionDto)));
    }
}
