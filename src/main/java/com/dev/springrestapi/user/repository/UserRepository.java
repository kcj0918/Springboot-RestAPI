package com.dev.springrestapi.user.repository;

import com.dev.springrestapi.user.domain.User;
import com.dev.springrestapi.user.repository.querydsl.interfaces.UserQueryDSLInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserQueryDSLInterface {
}
