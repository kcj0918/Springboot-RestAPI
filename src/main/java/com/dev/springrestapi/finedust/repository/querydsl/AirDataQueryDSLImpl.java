package com.dev.springrestapi.finedust.repository.querydsl;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.domain.QAirData;
import com.dev.springrestapi.finedust.repository.querydsl.interfaces.AirDataQueryDSLInterface;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirDataQueryDSLImpl extends QuerydslRepositorySupport implements AirDataQueryDSLInterface {
    private QAirData qAirData = QAirData.airData;

    public AirDataQueryDSLImpl() {
        super(AirData.class);
    }

    @Override
    public List<AirData> getAirDataByStationName(String beginDate, String endDate, String stationName) {
        return null;
    }
}