package com.dev.springrestapi.finedust.repository.querydsl;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.domain.QAirData;
import com.dev.springrestapi.finedust.repository.querydsl.interfaces.AirDataQueryDSLInterface;
import com.dev.springrestapi.util.res.StringToLocalDateTime;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirDataRepositoryImpl extends QuerydslRepositorySupport implements AirDataQueryDSLInterface {
    private QAirData qAirData = QAirData.airData;

    public AirDataRepositoryImpl() {
        super(AirData.class);
    }

    @Override
    public List<AirData> getAirDataByStationName(String beginDate, String endDate, String stationName) {
        StringToLocalDateTime stringToLocalDateTime = new StringToLocalDateTime(beginDate, endDate);
        return from(qAirData)
                .where(qAirData.stationName
                        .eq(stationName)
                        .and(qAirData.dataTime.between(
                                stringToLocalDateTime.getBeginDate(),
                                stringToLocalDateTime.getEndDate())))
                .fetch();
    }
}