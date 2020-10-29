package com.dev.springrestapi.finedust.controller;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.service.AirDataService;
import com.dev.springrestapi.util.res.DefaultResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
@AllArgsConstructor
@Api
public class AirDataController {
    private AirDataService airDataService;

    @GetMapping("airs")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getAirDatas() {
        List<AirData> airDatas = airDataService.getFindAll();
        return new ResponseEntity<>(new DefaultResponse(airDatas), HttpStatus.OK);
    }

    @GetMapping("airs/{beginDate}/{endDate}/{stationName}")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getAirDataBeginEndStationName(
            @PathVariable("beginDate") String beginDate,
            @PathVariable("endDate") String endDate,
            @PathVariable("stationName") String stationName) {
        List<AirData> airDatas = airDataService.getAirDataByStationName(beginDate, endDate, stationName);
        return new ResponseEntity<>(new DefaultResponse(airDatas), HttpStatus.OK);
    }
}
