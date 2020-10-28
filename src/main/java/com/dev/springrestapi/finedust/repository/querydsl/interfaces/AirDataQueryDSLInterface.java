package com.dev.springrestapi.finedust.repository.querydsl.interfaces;

import com.dev.springrestapi.finedust.domain.AirData;

public interface AirDataQueryDSLInterface {
    AirData getAirDataByStationName(String beginDate, String endDate, String stationName);
}
