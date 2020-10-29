package com.dev.springrestapi.finedust.service;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.dto.response.airdata.GetAirDataResponseDto;
import com.dev.springrestapi.finedust.repository.AirDataRepository;
import com.dev.springrestapi.finedust.repository.querydsl.interfaces.AirDataQueryDSLInterface;
import com.dev.springrestapi.finedust.service.interfaces.AirDataServiceInterface;
import com.dev.springrestapi.util.res.StringToLocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service("AirDataService")
public class AirDataService implements AirDataServiceInterface, AirDataQueryDSLInterface {
    private AirDataRepository airDataRepository;

    public List<AirData> getFindAll() {
        return airDataRepository.findAll();
    }

    @Override
    public List<AirData> getAirDataByStationName(String beginDate, String endDate, String stationName) {
        return airDataRepository.getAirDataByStationName(beginDate, endDate, stationName);
    }
}
