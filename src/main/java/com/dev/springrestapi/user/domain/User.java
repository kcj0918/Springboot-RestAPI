package com.dev.springrestapi.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long idx;

    private String email;

    private String name;

    @Builder
    public User(Long idx, String email, String name) {
        this.idx = idx;
        this.email = email;
        this.name = name;
    }
}
