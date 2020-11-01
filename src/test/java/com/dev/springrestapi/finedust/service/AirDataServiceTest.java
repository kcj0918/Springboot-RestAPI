package com.dev.springrestapi.finedust.service;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.repository.AirDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AirDataServiceTest {
    @InjectMocks
    private AirDataService airDataService;

    @Mock
    private AirDataRepository airDataRepository;

    @AfterEach
    public void tearDown() {
        airDataRepository.deleteAll();
    }

    @Test
    public void 시작날짜_끝나는날짜_지역명_조회() {
        LocalDateTime localDateTime;
        for (int i = 13; i < 17; i++) {
            localDateTime = LocalDateTime.of(2020, 10, 29, i, 0, 0);
            AirData airData = AirData.builder()
                    .dataTime(localDateTime)
                    .stationName("반송로")
                    .build();
            airDataRepository.save(airData);
        }
        airDataService.getAirDataByStationName("2020-10-29 13:30:00", "2020-10-29 15:30:00", "반송로");

        verify(airDataRepository).getAirDataByStationName("2020-10-29 13:30:00", "2020-10-29 15:30:00", "반송로");
    }
}
