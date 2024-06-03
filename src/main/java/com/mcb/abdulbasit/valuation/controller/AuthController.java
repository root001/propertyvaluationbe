package com.mcb.abdulbasit.valuation.controller;

import com.mcb.abdulbasit.valuation.exception.NotFoundException;
import com.mcb.abdulbasit.valuation.model.AuthRequest;
import com.mcb.abdulbasit.valuation.model.AuthResponse;
import com.mcb.abdulbasit.valuation.service.AuthService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.mcb.abdulbasit.valuation.constant.AppConstants.AUTH;
import static com.mcb.abdulbasit.valuation.constant.AppConstants.LOGIN;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping(LOGIN)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        log.info("username {} has value, fetch params", authRequest.username());
        if(ObjectUtils.isEmpty(authRequest) || StringUtils.isEmpty(authRequest.username())
                || StringUtils.isEmpty(authRequest.password()) )
            throw new IllegalArgumentException("Illegal Credentials provided.");
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }
}
