package com.spring.petabyte.mapper;

import com.spring.petabyte.dto.role.RoleAddDto;
import com.spring.petabyte.dto.role.RoleDto;
import com.spring.petabyte.entity.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class RoleMapper {
    @Autowired
    protected PermissionMapper permissionMapper;

    public Role toEntity(RoleAddDto roleDto) {
        return Role.builder()
                .name(roleDto.getName())
                .value(roleDto.getValue())
                .permissions(roleDto.getPermissions().stream()
                        .map(permission -> permissionMapper.toEntity(permission))
                        .collect(Collectors.toSet()))
                .build();
    }

    public RoleDto toDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .value(role.getValue())
                .build();
    }
}
