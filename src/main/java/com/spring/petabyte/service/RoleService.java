package com.spring.petabyte.service;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.role.RoleAddDto;
import com.spring.petabyte.dto.role.RoleDto;

public interface RoleService {
    ResponseDto<RoleDto> create(RoleAddDto roleDto);
}
