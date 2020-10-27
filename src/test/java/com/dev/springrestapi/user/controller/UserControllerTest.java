package com.dev.springrestapi.user.controller;

import com.dev.springrestapi.user.domain.User;
import com.dev.springrestapi.user.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.user.service.UserService;
import com.dev.springrestapi.util.res.ObjectJsonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void signUpTest() throws Exception {
        UserAddRequestDto userAddRequestDto = UserAddRequestDto.builder()
                .email("test1@test.com")
                .name("test1")
                .build();
        mockMvc
                .perform(post("/user/sign/up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ObjectJsonMapper.process(userAddRequestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getUserByEmail() throws Exception {
        User getUser = User.builder()
                .email("test@test.com")
                .name("test")
                .build();
        when(userService.getUserByEmail("test@test.com")).thenReturn(getUser);
        mockMvc
                .perform(get("/user/{email}", "test@test.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
