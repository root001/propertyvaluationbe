package com.mcb.abdulbasit.valuation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.abdulbasit.valuation.config.AppTestConfig;
import com.mcb.abdulbasit.valuation.exception.ResponseExceptionHandler;
import com.mcb.abdulbasit.valuation.service.FacilityService;
import com.mcb.abdulbasit.valuation.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FacilityController.class})
@AutoConfigureMockMvc
@ContextConfiguration(classes = {AppTestConfig.class, ResponseExceptionHandler.class})
class FacilityControllerTest {

    @MockBean
    private FacilityService facilityService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private final static Integer someid = 4;

    @BeforeEach
    void setUp() {
        ((MockServletContext) mockMvc.getDispatcherServlet().getServletContext()).setContextPath("/api");
    }



}