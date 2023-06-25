package com.spring.petabyte.dto.role;

import com.spring.petabyte.dto.permission.PermissionDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleAddDto {
    private Long id;

    @NotEmpty(message = "Название не должно быть пустым")
    private String name;

    @NotEmpty(message = "Значение не должно быть пустым")
    private String value;

    @NotNull(message = "Разрешения не должны быть пустыми")
    private Set<PermissionDto> permissions;
}
