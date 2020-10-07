package com.dev.springrestapi.dto.request.user;

import com.dev.springrestapi.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserAddRequestDto {
    private String email;
    private String name;

    @Builder
    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .build();
    }
}
