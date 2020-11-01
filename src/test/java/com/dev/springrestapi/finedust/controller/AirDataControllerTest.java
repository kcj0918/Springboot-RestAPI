package com.dev.springrestapi.finedust.controller;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.service.AirDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirDataController.class)
@ExtendWith(SpringExtension.class)
public class AirDataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirDataService airDataService;

    @Test
    public void 시작날짜_끝나는날짜_지역명_조회() throws Exception {
        List<AirData> airDatas = new ArrayList<>();
        AirData airData = AirData.builder()
                .dataTime(LocalDateTime.of(2020, 10, 29, 1, 0, 0))
                .stationName("반송로")
                .build();
        airDatas.add(airData);
        when(airDataService.getAirDataByStationName(
                "2020-10-29 13:30:00",
                "2020-10-29 15:30:00",
                "반송로"))
                .thenReturn(airDatas);
        mockMvc
                .perform(get(
                        "/airs/{beginDate}/{endDate}/{stationName}",
                        "2020-10-29 13:30:00",
                        "2020-10-29 15:30:00",
                        "반송로")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
