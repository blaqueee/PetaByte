package com.spring.petabyte.dto.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDto {

    @NotEmpty(message = "Имя не должно быть пустым")
    private String firstName;

    private String middleName;

    @NotEmpty(message = "Фамилия не должна быть пустой")
    private String lastName;

    @NotEmpty(message = "Почта обязательна к заполнению")
    private String email;

    @NotEmpty(message = "Номер телефона не должен быть пустым")
    private String phoneNumber;

    @NotNull(message = "Роль обязательная к заполнению")
    private Long roleId;

    private String password;

}
