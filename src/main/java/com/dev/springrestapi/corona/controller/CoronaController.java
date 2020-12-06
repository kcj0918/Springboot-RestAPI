package com.dev.springrestapi.corona.controller;

import com.dev.springrestapi.corona.domain.Corona;
import com.dev.springrestapi.corona.dto.request.corona.CoronaRequestDto;
import com.dev.springrestapi.corona.service.CoronaService;
import com.dev.springrestapi.corona.util.exception.corona.CoronaRequestWrongFormatException;
import com.dev.springrestapi.util.res.DefaultResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("corona")
@AllArgsConstructor
@Api
public class CoronaController {

    private CoronaService coronaService;

    @GetMapping("allData")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getCorona(){
        List<Corona> coronaData = coronaService.getFindAll();
        return new ResponseEntity<>(new DefaultResponse(coronaData), HttpStatus.OK);
    }

    @GetMapping("dailyCountryName")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getCoronaBeginEndCountryName(
       @ModelAttribute @Valid CoronaRequestDto coronaRequestDto, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            throw new CoronaRequestWrongFormatException();
        }
        List<Corona> coronaData = coronaService.getCoronaByCountryName(
                coronaRequestDto.getBeginDate(),
                coronaRequestDto.getEndDate(),
                coronaRequestDto.getCountryName());

        return new ResponseEntity<>(new DefaultResponse(coronaData), HttpStatus.OK);
    }
}
