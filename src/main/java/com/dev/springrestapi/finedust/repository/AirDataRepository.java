package com.dev.springrestapi.finedust.repository;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.repository.querydsl.interfaces.AirDataQueryDSLInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirDataRepository extends JpaRepository<AirData, Long>, AirDataQueryDSLInterface {
}
