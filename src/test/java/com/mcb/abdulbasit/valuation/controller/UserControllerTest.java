package com.mcb.abdulbasit.valuation.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.abdulbasit.valuation.config.AppTestConfig;
import com.mcb.abdulbasit.valuation.exception.ResponseExceptionHandler;
import com.mcb.abdulbasit.valuation.model.User;
import com.mcb.abdulbasit.valuation.service.UserService;
import com.mcb.abdulbasit.valuation.util.EasyRandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UserController.class})
@AutoConfigureMockMvc
@ContextConfiguration(classes = {AppTestConfig.class, ResponseExceptionHandler.class})
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private final static Integer someid = 12;

    @BeforeEach
    void setUp() {
        ((MockServletContext) mockMvc.getDispatcherServlet().getServletContext()).setContextPath("/api");
    }

    @Test
    void given_that_users_exist_return_all_users() throws Exception {
        List<User> userList = EasyRandomUtils.mock(User.class, 5);

        when(userService.getAllUsers()).thenReturn(userList);
        final var result = mockMvc.perform(get("/api/v1/users", someid)
                        .contextPath("/api")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        final var responseList = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<User>>() {
        });

        Assertions.assertThat(responseList.size()).isEqualTo(userList.size());
    }

    @Test
    void findUser() {
    }
}