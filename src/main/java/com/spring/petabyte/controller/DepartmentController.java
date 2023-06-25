package com.spring.petabyte.controller;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.department.DepartmentDto;
import com.spring.petabyte.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ResponseDto<DepartmentDto>> create(@Valid @RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(ResponseDto.success(departmentService.create(departmentDto)));
    }

}
