package com.spring.petabyte.dto.user;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotEmpty(message = "Почта не должна быть пустой")
    private String email;

    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;

}
