package com.spring.petabyte.service;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.permission.PermissionDto;

public interface PermissionService {
    ResponseDto<PermissionDto> create(PermissionDto permissionDto);
}
