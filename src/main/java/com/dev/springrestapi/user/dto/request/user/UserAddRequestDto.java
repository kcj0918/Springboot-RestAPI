package com.dev.springrestapi.user.dto.request.user;

import lombok.*;

@Getter
@Setter
@Builder
public class UserAddRequestDto {
    private String email;
    private String name;

    @Builder
    public UserAddRequestDto(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
