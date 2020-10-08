package com.dev.springrestapi.service.interfaces;

import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.dto.response.DefaultResponse;

public interface UserServiceInterface {
    void addUser(UserAddRequestDto userAddRequestDto);
    User getUser(String email);
    Boolean isEmailExist(String email);
    DefaultResponse getUserByEmail();
}
