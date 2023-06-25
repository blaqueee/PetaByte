package com.spring.petabyte.entity;

import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @Column(name = "is_blocked", columnDefinition = "boolean default false")
    private Boolean isBlocked;

    @Column(name = "is_enabled", columnDefinition = "boolean default true")
    private Boolean isEnabled;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @Column(name = "password", nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions().stream()
                .map(Permission::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return code;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isBlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isBlocked;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
