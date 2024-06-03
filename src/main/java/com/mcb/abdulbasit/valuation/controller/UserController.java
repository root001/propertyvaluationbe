package com.mcb.abdulbasit.valuation.controller;

import com.mcb.abdulbasit.valuation.model.User;
import com.mcb.abdulbasit.valuation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mcb.abdulbasit.valuation.constant.AppConstants.USER;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * findAllUsers
     * @return
     */
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * findUser
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(Integer.getInteger(id)) );
    }

    @GetMapping("/save")
    public ResponseEntity<User> save() {
        return ResponseEntity.ok(userService.save() );
    }
}
