package com.mcb.abdulbasit.valuation.model;

import java.time.LocalDateTime;

public record AuthResponse(String token, LocalDateTime expiresAt) {
}