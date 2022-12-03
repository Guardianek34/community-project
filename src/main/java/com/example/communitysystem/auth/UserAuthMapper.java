package com.example.communitysystem.auth;

import com.example.communitysystem.auth.dto.LoginRequest;
import com.example.communitysystem.auth.dto.SignupRequest;
import com.example.communitysystem.auth.dto.UserInfoResponse;
import com.example.communitysystem.security.UserDetailsSecurity;
import com.example.communitysystem.user.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAuthMapper {

    private final PasswordEncoder encoder;

    public UserAuth toUser(SignupRequest credentials) {
        return UserAuth.builder()
                .username(credentials.username())
                .password(encoder.encode(credentials.password()))
                .profile(UserProfile.builder()
                        .name(credentials.username())
                        .email(credentials.email())
                        .build())
                .build();
    }

    public UserInfoResponse toResponse(UserDetailsSecurity userDetails) {
        return UserInfoResponse.builder()
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .build();
    }
}
