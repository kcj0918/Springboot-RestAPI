package com.dev.springrestapi.user.service.interfaces;

import com.dev.springrestapi.user.dto.request.user.UserAddRequestDto;

public interface UserServiceInterface {
    void addUser(UserAddRequestDto userAddRequestDto);

    Boolean isEmailExist(String email);
}
