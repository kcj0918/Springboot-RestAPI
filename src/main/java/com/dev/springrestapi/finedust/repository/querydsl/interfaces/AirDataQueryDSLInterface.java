package com.dev.springrestapi.finedust.repository.querydsl.interfaces;

import com.dev.springrestapi.finedust.domain.AirData;

import java.util.List;

public interface AirDataQueryDSLInterface {
    List<AirData> getAirDataByStationName(String beginDate, String endDate, String stationName);
}
