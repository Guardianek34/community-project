package com.example.communitysystem.auth;

import com.example.communitysystem.auth.dto.LoginRequest;
import com.example.communitysystem.auth.dto.SignupRequest;
import com.example.communitysystem.auth.exception.UsernameNotUniqueException;
import com.example.communitysystem.security.UserDetailsSecurity;
import com.example.communitysystem.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserAuthRepository userRepository;
    private final UserAuthMapper mapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public void registerUser(SignupRequest credentials) {
        String username = credentials.username();
        if(this.userRepository.existsByUsername(username)){
            throw new UsernameNotUniqueException();
        }

        userRepository.save(mapper.toUser(credentials));
    }

    public UserDetailsSecurity authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.username(),
                                loginRequest.password()
                        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsSecurity userDetails = (UserDetailsSecurity) authentication.getPrincipal();

        return userDetails;
    }
}
