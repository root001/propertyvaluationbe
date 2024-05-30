package com.mcb.abdulbasit.valuation.controller;

import com.mcb.abdulbasit.valuation.config.AppTestConfig;
import com.mcb.abdulbasit.valuation.exception.ResponseExceptionHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UserController.class})
@AutoConfigureMockMvc
@ContextConfiguration(classes = {AppTestConfig.class, ResponseExceptionHandler.class})
class UserControllerTest {

    @Test
    void findAllUsers() {
    }

    @Test
    void findUser() {
    }
}