package com.dev.springrestapi.service;

import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.exception.user.UserConflictException;
import com.dev.springrestapi.repository.UserRepository;
import com.dev.springrestapi.repository.querydsl.interfaces.UserQueryDSLInterface;
import com.dev.springrestapi.service.interfaces.UserServiceInterface;
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
