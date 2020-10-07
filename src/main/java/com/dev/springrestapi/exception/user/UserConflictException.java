package com.dev.springrestapi.exception.user;

public class UserConflictException extends RuntimeException {
    public UserConflictException(String msg) {
        super(msg);
    }
}
