package com.dev.springrestapi.dto.response.user;

import com.dev.springrestapi.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserAddResponseDto {
    private Long idx;
    private String email;
    private String name;

    @Builder
    public User toEntity() {
        return User.builder()
                .idx(idx)
                .email(email)
                .name(name)
                .build();
    }
}
