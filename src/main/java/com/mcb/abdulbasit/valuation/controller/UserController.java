package com.mcb.abdulbasit.valuation.controller;

import com.mcb.abdulbasit.valuation.constant.AppConstants;
import com.mcb.abdulbasit.valuation.model.Users;
import com.mcb.abdulbasit.valuation.service.UserService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppConstants.USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * findAllUsers
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Users>> findAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * findUser
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Users> findUser(@PathVariable Integer id) {
        if(id < 0)
            throw new IllegalArgumentException("Illegal id provided.");
        return ResponseEntity.ok(userService.getUser(id) );
    }

}
