package com.spring.petabyte.dto.permission;

import javax.validation.constraints.NotEmpty;

public class PermissionDto {
    private Long id;

    @NotEmpty(message = "Название не должно быть пустым")
    private String name;

    @NotEmpty(message = "Значение не должно быть пустым")
    private String value;
}
