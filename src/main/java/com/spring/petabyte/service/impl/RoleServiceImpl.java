package com.spring.petabyte.service.impl;

import com.spring.petabyte.dto.role.RoleAddDto;
import com.spring.petabyte.dto.role.RoleDto;
import com.spring.petabyte.entity.Role;
import com.spring.petabyte.exception.NotFoundException;
import com.spring.petabyte.mapper.RoleMapper;
import com.spring.petabyte.repository.RoleRepository;
import com.spring.petabyte.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto create(RoleAddDto roleDto) throws NotFoundException {
        Role role = roleMapper.toEntity(roleDto);
        Role saved = roleRepository.save(role);
        return roleMapper.toDto(saved);
    }
}
