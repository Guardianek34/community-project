package com.example.communitysystem.security;

import com.example.communitysystem.auth.UserAuth;
import com.example.communitysystem.auth.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsSecurityService implements UserDetailsService {

    private final UserAuthRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsMapper.mapFrom(user);
    }
}
