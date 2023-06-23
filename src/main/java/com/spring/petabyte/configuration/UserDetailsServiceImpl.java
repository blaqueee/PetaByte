package com.spring.petabyte.configuration;

import com.spring.petabyte.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
        return userRepository.findByCode(code)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не существует"));
    }
}
