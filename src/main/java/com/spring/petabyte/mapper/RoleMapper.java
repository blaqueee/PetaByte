package com.spring.petabyte.mapper;

import com.spring.petabyte.dto.role.RoleAddDto;
import com.spring.petabyte.dto.role.RoleDto;
import com.spring.petabyte.entity.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class RoleMapper {

    public abstract Role toEntity(RoleAddDto roleDto);
    public abstract RoleDto toDto(Role role);

}
