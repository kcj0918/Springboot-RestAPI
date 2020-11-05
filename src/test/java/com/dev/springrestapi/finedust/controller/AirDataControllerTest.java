package com.dev.springrestapi.finedust.controller;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.dto.request.airdata.AirDataRequestDto;
import com.dev.springrestapi.finedust.service.AirDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirDataController.class)
@ExtendWith(SpringExtension.class)
public class AirDataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirDataService airDataService;

    @Test
    @DisplayName("정상적인_AirData_조회")
    public void getAirDataTest() throws Exception {
        List<AirData> airDatas = new ArrayList<>();
        AirData airData = AirData.builder()
                .dataTime(LocalDateTime.of(2020, 10, 29, 14, 0, 0))
                .stationName("반송로")
                .build();
        airDatas.add(airData);
        when(airDataService.getAirDataByStationName(
                "2020-10-29 13:30:00",
                "2020-10-29 15:30:00",
                "반송로"))
                .thenReturn(airDatas);
        AirDataRequestDto airDataRequestDto = AirDataRequestDto.builder()
                .beginDate("2020-10-29 13:30:00").endDate("2020-10-29 15:30:00").stationName("반송로")
                .build();
        mockMvc
                .perform(get("/airs/stationName")
                        .param("beginDate", airDataRequestDto.getBeginDate())
                        .param("endDate", airDataRequestDto.getEndDate())
                        .param("stationName", airDataRequestDto.getStationName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value("SUCCESS"));
    }

    @Test
    @DisplayName("틀린_LocalDateTime_Format_AirData_조회")
    public void getAirData_Wrong_LocalDateTime_Format() throws Exception {
        AirDataRequestDto airDataRequestDto = AirDataRequestDto.builder()
                .beginDate("--").endDate("2020-10-29 15:30:00").stationName("반송로")
                .build();
        mockMvc
                .perform(get("/airs/stationName")
                        .param("beginDate", airDataRequestDto.getBeginDate())
                        .param("endDate", airDataRequestDto.getEndDate())
                        .param("stationName", airDataRequestDto.getStationName()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("틀린_StationName_Format_AirData_조회")
    public void getAirData_Wrong_StationName_Format() throws Exception {
        AirDataRequestDto airDataRequestDto = AirDataRequestDto.builder()
                .beginDate("2020-10-29 12:30:00").endDate("2020-10-29 15:30:00").stationName("")
                .build();
        mockMvc
                .perform(get("/airs/stationName")
                        .param("beginDate", airDataRequestDto.getBeginDate())
                        .param("endDate", airDataRequestDto.getEndDate())
                        .param("stationName", airDataRequestDto.getStationName()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
