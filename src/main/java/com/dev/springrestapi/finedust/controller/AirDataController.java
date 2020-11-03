package com.dev.springrestapi.finedust.controller;

import com.dev.springrestapi.finedust.domain.AirData;
import com.dev.springrestapi.finedust.dto.request.airdata.AirDataRequestDto;
import com.dev.springrestapi.finedust.exception.airdata.MisMatchDateTimeFormatException;
import com.dev.springrestapi.finedust.service.AirDataService;
import com.dev.springrestapi.util.res.DefaultResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
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

    @GetMapping("airs/stationName")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getAirDataBeginEndStationName(
            @ModelAttribute @Valid AirDataRequestDto airDataRequestDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new MisMatchDateTimeFormatException();
        }
        List<AirData> airDatas = airDataService.getAirDataByStationName(
                airDataRequestDto.getBeginDate(),
                airDataRequestDto.getEndDate(),
                airDataRequestDto.getStationName());

        return new ResponseEntity<>(new DefaultResponse(airDatas), HttpStatus.OK);
    }
}
