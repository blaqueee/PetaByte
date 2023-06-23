package com.spring.petabyte.service.impl;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.role.RoleAddDto;
import com.spring.petabyte.dto.role.RoleDto;
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
    public ResponseDto<RoleDto> create(RoleAddDto roleDto) {
        throw new RuntimeException();
    }
}
