package com.dev.springrestapi.user.exception.user;

public class UserConflictException extends RuntimeException {
    public UserConflictException(String msg) {
        super(msg);
    }
}
