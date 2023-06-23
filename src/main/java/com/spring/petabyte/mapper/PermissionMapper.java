package com.spring.petabyte.mapper;

import com.spring.petabyte.dto.permission.PermissionDto;
import com.spring.petabyte.entity.Permission;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PermissionMapper {

    public abstract Permission toEntity(PermissionDto permissionDto);

    public abstract PermissionDto toDto(Permission permission);

}
