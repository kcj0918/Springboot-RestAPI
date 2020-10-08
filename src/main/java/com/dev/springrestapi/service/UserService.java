package com.dev.springrestapi.service;

import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.dto.response.DefaultResponse;
import com.dev.springrestapi.repository.UserRepository;
import com.dev.springrestapi.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service("UserService")
public class UserService implements UserServiceInterface {
    private UserRepository userRepository;


    @Override
    public void addUser(UserAddRequestDto userAddRequestDto) {
        User user = User.builder()
                .email(userAddRequestDto.getEmail())
                .name(userAddRequestDto.getName())
                .build();
        userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public Boolean isEmailExist(String email) {
        return true;
    }

    @Override
    public DefaultResponse getUserByEmail() {
        return null;
    }


}
