package com.dev.springrestapi.corona.service;


import com.dev.springrestapi.corona.domain.Corona;
import com.dev.springrestapi.corona.repository.CoronaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CoronaServiceTest {

    @InjectMocks
    private CoronaService coronaService;

    @Mock
    private CoronaRepository coronaRepository;

    @AfterEach
    public void tearDown(){
        coronaRepository.deleteAll();
    }

    @Test
    @DisplayName("시작날짜_끝나는날짜_지역명_조회")
    public void getCoronaBeginEndCountryName_Test() {
        LocalDateTime localDateTime;
        for (int i = 13; i < 17; i++) {
            localDateTime = LocalDateTime.of(2020, 12, 9, i, 0, 0);
            Corona corona = Corona.builder()
                    .createDt(localDateTime)
                    .countryName("서울")
                    .build();
            coronaRepository.save(corona);
        }
        coronaService.getCoronaByCountryName("2020-12-08 00:00:00", "2020-12-09 23:00:00", "서울");

        verify(coronaRepository).getCoronaByCountryName("2020-12-08 00:00:00", "2020-12-09 23:00:00", "서울");

    }

}
