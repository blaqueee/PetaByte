package com.spring.petabyte.dto.permission;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionDto {
    private Long id;

    @NotEmpty(message = "Название не должно быть пустым")
    private String name;

    @NotEmpty(message = "Значение не должно быть пустым")
    private String value;
}
