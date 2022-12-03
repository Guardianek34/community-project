package com.example.communitysystem.auth;

import com.example.communitysystem.auth.dto.LoginRequest;
import com.example.communitysystem.auth.dto.MessageResponse;
import com.example.communitysystem.auth.dto.SignupRequest;
import com.example.communitysystem.security.UserDetailsSecurity;
import com.example.communitysystem.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAuthService userService;
    private final JwtUtils jwtUtils;
    private final UserAuthMapper mapper;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        UserDetailsSecurity userData = this.userService.authenticateUser(loginRequest);
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userData);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(mapper.toResponse(userData));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest userCredentials) {
        this.userService.registerUser(userCredentials);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.generateEmptyCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("You've been signed out!");
    }
}
