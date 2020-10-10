package com.dev.springrestapi.dto.response.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetUserResponseDto {
    private String email;
    private String name;

    public GetUserResponseDto(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
