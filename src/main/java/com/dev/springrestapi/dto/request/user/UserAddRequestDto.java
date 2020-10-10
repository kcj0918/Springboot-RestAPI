package com.dev.springrestapi.dto.request.user;

import com.dev.springrestapi.domain.User;
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
