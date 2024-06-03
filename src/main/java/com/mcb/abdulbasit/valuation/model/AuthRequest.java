package com.mcb.abdulbasit.valuation.model;

import jakarta.validation.constraints.NotNull;

public record AuthRequest(@NotNull String username, @NotNull String password) {
}
