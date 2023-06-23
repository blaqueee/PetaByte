package com.spring.petabyte.utils;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthUtils {
    private static final Logger LOG = LoggerFactory.getLogger(AuthUtils.class);
    private final PasswordEncoder passwordEncoder;

    public String generateRandomPassword() {
        LOG.info("Creating a random password for user...");
        List<Character> rnd = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rnd.add((char) ThreadLocalRandom.current().nextInt('0', '9'));
            rnd.add((char) ThreadLocalRandom.current().nextInt('a', 'z'));
            rnd.add((char) ThreadLocalRandom.current().nextInt('A', 'Z'));
        }
        Collections.shuffle(rnd);
        return rnd.stream().limit(10).map(String::valueOf).collect(Collectors.joining());
    }

    public String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
