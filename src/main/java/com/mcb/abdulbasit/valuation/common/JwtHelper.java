package com.mcb.abdulbasit.valuation.common;

import com.mcb.abdulbasit.valuation.model.User;

import java.time.LocalDateTime;

public interface JwtHelper {
    String extractUserNameFromToken(String token);

    String generateTokenForUser(User userDetails);

    boolean authenticateByToken(String token, User userDetails);

    LocalDateTime getTokenExpiration(String token);
}
