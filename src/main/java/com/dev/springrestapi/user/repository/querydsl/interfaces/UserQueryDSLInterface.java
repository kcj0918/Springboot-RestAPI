package com.dev.springrestapi.user.repository.querydsl.interfaces;

import com.dev.springrestapi.user.domain.User;

public interface UserQueryDSLInterface {
    User getUserByEmail(String email);
}
