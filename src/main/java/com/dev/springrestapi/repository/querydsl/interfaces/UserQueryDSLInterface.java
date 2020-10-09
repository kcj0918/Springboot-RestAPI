package com.dev.springrestapi.repository.querydsl.interfaces;

import com.dev.springrestapi.domain.User;

public interface UserQueryDSLInterface {
    User getUserByEmail(String email);
}
