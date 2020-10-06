package com.dev.springrestapi.repository;

import com.dev.springrestapi.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void 유저조회() {
        //given
        userRepository.save(User.builder()
                .email("테스트 이메일")
                .name("테스트 이름")
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User users = userList.get(0);
        assertThat(users.getEmail(), is("테스트 이메일"));
        assertThat(users.getName(), is("테스트 이름"));
    }
}
