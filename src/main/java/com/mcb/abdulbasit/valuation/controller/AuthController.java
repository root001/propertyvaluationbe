package com.mcb.abdulbasit.valuation.controller;

import com.mcb.abdulbasit.valuation.model.AuthRequest;
import com.mcb.abdulbasit.valuation.model.AuthResponse;
import com.mcb.abdulbasit.valuation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.mcb.abdulbasit.valuation.constant.AppConstants.AUTH;
import static com.mcb.abdulbasit.valuation.constant.AppConstants.LOGIN;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(LOGIN)
    @CrossOrigin
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }
}
