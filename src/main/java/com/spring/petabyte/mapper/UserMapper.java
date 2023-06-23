package com.spring.petabyte.mapper;


import com.spring.petabyte.dto.user.UserDto;
import com.spring.petabyte.dto.user.UserRegisterDto;
import com.spring.petabyte.entity.User;
import com.spring.petabyte.exception.NotFoundException;
import com.spring.petabyte.repository.DepartmentRepository;
import com.spring.petabyte.repository.RoleRepository;
import com.spring.petabyte.utils.AuthUtils;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {
    @Autowired
    protected DepartmentRepository departmentRepository;
    @Autowired
    protected RoleRepository roleRepository;
    @Autowired
    protected PasswordEncoder passwordEncoder;
    @Autowired
    protected AuthUtils authUtils;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(dto.getPassword()))")
    @Mapping(target = "department", expression = "java(departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new NotFoundException(\"Отдел не найден\")))")
    @Mapping(target = "role", expression = "java(roleRepository.findById(dto.getRoleId()).orElseThrow(() -> new NotFoundException(\"Роль не найдена\")))")
    @Mapping(target = "code", expression = "java(dto.getEmail())")
    @Mapping(target = "password", expression = "java(authUtils.encryptPassword(dto.getPassword()))")
    public abstract User toNewUser(UserRegisterDto dto) throws NotFoundException;

    @Mapping(target = "accessToken", defaultValue = "")
    @Mapping(target = "role", expression = "java()")
    public abstract UserDto toDto(User user);
}
