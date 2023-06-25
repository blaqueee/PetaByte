package com.spring.petabyte.dto.department;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {

    private Long id;

    @NotEmpty(message = "Название не должно быть пустым")
    private String name;

    @NotEmpty(message = "Адрес не должен быть пустым")
    private String address;

}
