package com.dev.springrestapi.finedust.repository;

import com.dev.springrestapi.finedust.domain.AirData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class AirDataRepositoryTest {
    @Autowired
    private AirDataRepository airDataRepository;

    @Test
    public void 시작날짜_끝나는날짜_지역명에_전부_부합되는_케이스() {
        LocalDateTime localDateTime;
        for (int i = 13; i < 17; i++) {
            localDateTime = LocalDateTime.of(2020, 10, 29, i, 0, 0);
            AirData airData = AirData.builder()
                    .dataTime(localDateTime)
                    .stationName("반송로")
                    .build();
            airDataRepository.save(airData);
        }

        List<AirData> getAirData = airDataRepository.getAirDataByStationName("2020-10-29 13:30:00", "2020-10-29 15:30:00", "반송로");

        assertThat(getAirData.get(0).getDataTime(), is(LocalDateTime.of(2020, 10, 29, 14, 0, 0)));
        assertThat(getAirData.get(0).getStationName(), is("반송로"));
        assertThat(getAirData.get(1).getDataTime(), is(LocalDateTime.of(2020, 10, 29, 15, 0, 0)));
        assertThat(getAirData.get(1).getStationName(), is("반송로"));
    }
}
