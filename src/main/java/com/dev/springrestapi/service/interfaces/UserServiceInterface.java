package com.dev.springrestapi.service.interfaces;

import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.dto.request.user.UserAddRequestDto;

public interface UserServiceInterface {
    void addUser(UserAddRequestDto userAddRequestDto);
    User getUser(String email);
    Boolean isEmailExist(String email);
}
