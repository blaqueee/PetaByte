package com.spring.petabyte.utils;

import com.spring.petabyte.entity.User;
import javax.validation.constraints.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getCurrentAuditor")
public class SpringSecurityAuditorAware implements AuditorAware<User> {

    @Override
    public @NotNull Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        return Optional.of((User) authentication.getPrincipal());
    }
}
