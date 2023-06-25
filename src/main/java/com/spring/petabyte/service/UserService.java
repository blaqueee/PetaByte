package com.spring.petabyte.service;

import com.spring.petabyte.dto.user.UserDto;
import com.spring.petabyte.dto.user.UserRegisterDto;

public interface UserService {
    UserDto registerUser(UserRegisterDto userDto);
}
