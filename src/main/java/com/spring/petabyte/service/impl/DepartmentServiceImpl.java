package com.spring.petabyte.service.impl;

import com.spring.petabyte.dto.department.DepartmentDto;
import com.spring.petabyte.entity.Department;
import com.spring.petabyte.mapper.DepartmentMapper;
import com.spring.petabyte.repository.DepartmentRepository;
import com.spring.petabyte.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        Department department = departmentMapper.toEntity(departmentDto);
        Department saved = departmentRepository.save(department);
        return departmentMapper.toDto(saved);
    }
}
