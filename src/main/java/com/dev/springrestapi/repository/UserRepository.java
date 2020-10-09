package com.dev.springrestapi.repository;

import com.dev.springrestapi.domain.User;
import com.dev.springrestapi.repository.querydsl.interfaces.UserQueryDSLInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserQueryDSLInterface {
}
