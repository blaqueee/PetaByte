package com.spring.petabyte.mapper;

import com.spring.petabyte.dto.department.DepartmentDto;
import com.spring.petabyte.entity.Department;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class DepartmentMapper {

    public abstract Department toEntity(DepartmentDto departmentDto);

    public abstract DepartmentDto toDto(Department department);

}
