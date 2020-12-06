package com.dev.springrestapi.corona.repository.querydsl.interfaces;

import com.dev.springrestapi.corona.domain.Corona;

import java.util.List;

public interface CoronaQueryDSLInterface {
    List<Corona> getCoronaByCountryName(String beginDate, String endDate, String countryName);
}
