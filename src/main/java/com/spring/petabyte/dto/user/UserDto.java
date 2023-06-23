package com.spring.petabyte.dto.user;

import com.spring.petabyte.dto.role.RoleDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private RoleDto role;
    private String accessToken;
}
