package com.example.communitysystem.security;

import com.example.communitysystem.auth.UserAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsMapper {

    public static UserDetailsSecurity mapFrom(UserAuth user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toList());

        return UserDetailsSecurity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}