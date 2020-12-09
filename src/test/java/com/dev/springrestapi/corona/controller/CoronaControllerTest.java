package com.dev.springrestapi.corona.controller;

import com.dev.springrestapi.corona.domain.Corona;
import com.dev.springrestapi.corona.dto.request.corona.CoronaRequestDto;
import com.dev.springrestapi.corona.service.CoronaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CoronaController.class)
@ExtendWith(SpringExtension.class)
public class CoronaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoronaService coronaService;

    @Test
    @DisplayName("정상_전체데이터조회")
    public void getAllCoronaData_OkTest() throws Exception{
        mockMvc.perform(get("/corona/allData"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value("SUCCESS"));
    }

    @Test
    @DisplayName("정상_일별_지역별_조회")
    public void getCoronaBeginEndCountryName_OkTest() throws Exception{

        List<Corona> coronaDatas = new ArrayList<>();
        Corona corona = Corona.builder()
                .createDt(LocalDateTime.of(2020,12,06,17,14,14))
                .countryName("서울")
                .build();
        coronaDatas.add(corona);

        when(coronaService.getCoronaByCountryName(
                "2020-12-06 05:00:00",
                "2020-12-07 05:00:00",
                    "서울"
                ))
                .thenReturn(coronaDatas);

        CoronaRequestDto coronaRequestDto = CoronaRequestDto.builder()
                .beginDate("2020-12-06 05:00:00")
                .endDate("2020-12-07 05:00:00")
                .countryName("서울")
                .build();

        mockMvc.perform(get("/corona/dailyCountryName")
                .param("beginDate", coronaRequestDto.getBeginDate())
                .param("endDate", coronaRequestDto.getEndDate())
                .param("countryName",coronaRequestDto.getCountryName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value("SUCCESS"));
    }

    @Test
    @DisplayName("WRONG_DATE_FORMAT_일별_지역별조회")
    public void getCoronaBeginEndCountryName_Wrong_Format_Date_Test() throws Exception{

       CoronaRequestDto coronaRequestDto = CoronaRequestDto.builder()
                .beginDate("--").endDate("2020-12-07-05:00:00").countryName("서울")
                .build();

        mockMvc.perform(get("/corona/dailyCountryName")
                .param("beginDate", coronaRequestDto.getBeginDate())
                .param("endDate", coronaRequestDto.getEndDate())
                .param("countryName",coronaRequestDto.getCountryName()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("WRONG_NAME_FORMAT_일별_지역별조회")
    public void getCoronaBeginEndCountryName_Wrong_Format_NAME_Test() throws Exception{

        CoronaRequestDto coronaRequestDto = CoronaRequestDto.builder()
                .beginDate("2020-12-07-05:00:00").endDate("2020-12-07-05:00:00").countryName("")
                .build();

        mockMvc.perform(get("/corona/dailyCountryName")
                .param("beginDate", coronaRequestDto.getBeginDate())
                .param("endDate", coronaRequestDto.getEndDate())
                .param("countryName",coronaRequestDto.getCountryName()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
