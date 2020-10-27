package com.dev.springrestapi.user.service;

import com.dev.springrestapi.user.domain.User;
import com.dev.springrestapi.user.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.user.exception.user.UserConflictException;
import com.dev.springrestapi.user.repository.UserRepository;
import com.dev.springrestapi.user.repository.querydsl.interfaces.UserQueryDSLInterface;
import com.dev.springrestapi.user.service.interfaces.UserServiceInterface;
import com.dev.springrestapi.util.res.Strings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service("UserService")
public class UserService implements UserServiceInterface, UserQueryDSLInterface {
    private UserRepository userRepository;

    @Override
    public void addUser(UserAddRequestDto userAddRequestDto) {
        if (isEmailExist(userAddRequestDto.getEmail())) {
            throw new UserConflictException(Strings.ALREADY_EXIST_EMAIL);
        }
        User addUser = User.builder()
                .email(userAddRequestDto.getEmail())
                .name(userAddRequestDto.getName())
                .build();
        userRepository.save(addUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public Boolean isEmailExist(String email) {
        return userRepository.getUserByEmail(email) != null;
    }
}
