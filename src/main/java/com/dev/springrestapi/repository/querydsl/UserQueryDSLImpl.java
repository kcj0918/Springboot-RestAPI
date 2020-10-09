package com.dev.springrestapi.repository.querydsl;

import com.dev.springrestapi.domain.QUser;
import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.repository.querydsl.interfaces.UserQueryDSLInterface;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserQueryDSLImpl extends QuerydslRepositorySupport implements UserQueryDSLInterface {
    private QUser qUser = QUser.user;

    public UserQueryDSLImpl() {
        super(User.class);
    }

    @Override
    public User getUserByEmail(String email) {
        return from(qUser).where(qUser.email.eq(email)).fetchOne();
    }
}
