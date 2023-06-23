package com.spring.petabyte.service.impl;

import com.spring.petabyte.dto.ResponseDto;
import com.spring.petabyte.dto.user.UserDto;
import com.spring.petabyte.dto.user.UserRegisterDto;
import com.spring.petabyte.entity.User;
import com.spring.petabyte.exception.LoginExistsException;
import com.spring.petabyte.exception.NotFoundException;
import com.spring.petabyte.mapper.UserMapper;
import com.spring.petabyte.repository.UserRepository;
import com.spring.petabyte.service.UserService;
import com.spring.petabyte.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthUtils authUtils;
    private final MailSenderService mailSender;

    @Override
    public ResponseDto<UserDto> registerUser(UserRegisterDto userDto) throws LoginExistsException, NotFoundException {
        Optional<User> byCode = userRepository.findByCode(userDto.getEmail());
        if (byCode.isPresent())
            throw new LoginExistsException(String.format("Пользователь с почтой '%s' уже существует", userDto.getEmail()));
        String password = authUtils.generateRandomPassword();
        userDto.setPassword(password);
        User newUser = userMapper.toNewUser(userDto);
        User savedUser = userRepository.save(newUser);
        sendMessage(savedUser.getUsername(), savedUser.getPassword());
        return new ResponseDto<>("success", userMapper.toDto(savedUser));
    }

    private void sendMessage(String username, String password) {
        Thread thread = new Thread(() -> {
            mailSender.sendMessage(username,
                    "PetaByte",
                    String.format("Логин: %s\nПароль: %s", username, password));
            }
        );
        thread.start();
    }
}
