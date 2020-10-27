package com.dev.springrestapi.user.dto.response.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserAddResponseDto {
    private String email;
    private String name;

    public UserAddResponseDto(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
