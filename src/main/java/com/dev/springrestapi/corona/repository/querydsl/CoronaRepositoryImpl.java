package com.dev.springrestapi.corona.repository.querydsl;

import com.dev.springrestapi.corona.domain.Corona;
import com.dev.springrestapi.corona.domain.QCorona;
import com.dev.springrestapi.corona.repository.querydsl.interfaces.CoronaQueryDSLInterface;
import com.dev.springrestapi.util.res.StringToLocalDateTime;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoronaRepositoryImpl extends QuerydslRepositorySupport implements CoronaQueryDSLInterface {

    private QCorona qCorona = QCorona.corona;
    public CoronaRepositoryImpl(){
        super(Corona.class);
    }

    @Override
    public List<Corona> getCoronaByCountryName(String beginDate, String endDate, String countryName) {
        StringToLocalDateTime stringToLocalDateTime = new StringToLocalDateTime(beginDate, endDate);
        return from(qCorona)
                .where(qCorona.countryName.eq(countryName)
                    .and(qCorona.createDt.between(
                            stringToLocalDateTime.getBeginDate(),
                            stringToLocalDateTime.getEndDate()
                    )))
                .fetch();
    }
}
