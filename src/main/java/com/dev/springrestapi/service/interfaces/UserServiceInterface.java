package com.dev.springrestapi.service.interfaces;

import com.dev.springrestapi.dto.request.user.UserAddRequestDto;

public interface UserServiceInterface {
    void addUser(UserAddRequestDto userAddRequestDto);

    Boolean isEmailExist(String email);
}
