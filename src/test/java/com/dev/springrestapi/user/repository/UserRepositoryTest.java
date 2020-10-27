package com.dev.springrestapi.user.repository;

import com.dev.springrestapi.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void addUserTest() throws Exception {
        //given
        User user = User.builder()
                .email("add test email")
                .name("add test name")
                .build();

        //when
        User saveUser = userRepository.save(user);

        //then
        assertThat(saveUser.getEmail(), is("add test email"));
        assertThat(saveUser.getName(), is("add test name"));
    }

    @Test
    public void getUserByEmailTest() {
        //given
        User user = User.builder()
                .email("get test email")
                .name("get test name")
                .build();
        userRepository.save(user);

        //when
        User getUser = userRepository.getUserByEmail("get test email");

        //then
        assertThat(getUser.getIdx(), is(notNullValue()));
        assertThat(getUser.getEmail(), is("get test email"));
        assertThat(getUser.getName(), is("get test name"));
    }
}
