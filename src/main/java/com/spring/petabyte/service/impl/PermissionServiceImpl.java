package com.spring.petabyte.service.impl;

import com.spring.petabyte.dto.permission.PermissionDto;
import com.spring.petabyte.entity.Permission;
import com.spring.petabyte.mapper.PermissionMapper;
import com.spring.petabyte.repository.PermissionRepository;
import com.spring.petabyte.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionDto create(PermissionDto permissionDto) {
        Permission permission = permissionMapper.toEntity(permissionDto);
        Permission saved = permissionRepository.save(permission);
        return permissionMapper.toDto(saved);
    }
}
