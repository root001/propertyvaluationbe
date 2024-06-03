package com.mcb.abdulbasit.valuation.service;

import com.mcb.abdulbasit.valuation.common.JwtHelper;
import com.mcb.abdulbasit.valuation.model.AuthRequest;
import com.mcb.abdulbasit.valuation.model.AuthResponse;
import com.mcb.abdulbasit.valuation.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final JwtHelper jwtHelper;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthResponse authenticate(AuthRequest authRequest) {
        //fetch username and password from db
        User loginUser = userService.getUserByUsername(authRequest.username());
        // match username
        if (!loginUser.getUsername().equals(authRequest.username()))
            throw new IllegalArgumentException("Invalid credentials");

        // match password
        boolean match = bCryptPasswordEncoder.matches(authRequest.password(), loginUser.getPassword());
        if (!match) throw new IllegalArgumentException("Invalid credentials");

        var user = new User(authRequest.username(), authRequest.password());

        var jwt = jwtHelper.generateTokenForUser(user);

        return new AuthResponse(jwt, jwtHelper.getTokenExpiration(jwt));
    }
}
