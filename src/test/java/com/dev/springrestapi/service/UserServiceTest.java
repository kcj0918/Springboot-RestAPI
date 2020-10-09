package com.dev.springrestapi.service;

import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void addUserTest() {
        //given
        UserAddRequestDto userAddRequestDto = new UserAddRequestDto();
        userAddRequestDto.setEmail("add test email");
        userAddRequestDto.setName("add test name");
        User addUser = userAddRequestDto.toEntity();
        userRepository.save(addUser);

        //when
        userService.addUser(userAddRequestDto);

        //then
        verify(userRepository).save(addUser);
    }

    @Test
    public void getUserByEmailTest() {
        //given
        User user = User.builder()
                .email("get test email")
                .name("get test name")
                .build();
        userRepository.save(user);
        when(userService.getUserByEmail("get test email")).thenReturn(user);

        //when
        User getUser = userService.getUserByEmail(user.getEmail());

        //then
        verify(userRepository).getUserByEmail(getUser.getEmail());
    }
}
