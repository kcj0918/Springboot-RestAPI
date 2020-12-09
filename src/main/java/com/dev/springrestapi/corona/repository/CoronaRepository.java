package com.dev.springrestapi.corona.repository;

import com.dev.springrestapi.corona.domain.Corona;
import com.dev.springrestapi.corona.repository.querydsl.interfaces.CoronaQueryDSLInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaRepository extends JpaRepository<Corona, Long>, CoronaQueryDSLInterface {
}
