package com.dev.springrestapi.corona.dto.request.corona;

import com.dev.springrestapi.corona.util.Strings;
import com.dev.springrestapi.corona.util.customvalid.corona.valid.DateFormatValid;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class CoronaRequestDto {

    @DateFormatValid
    String beginDate;

    @DateFormatValid
    String endDate;

    @NotBlank(message = Strings.CAN_NOT_CORONA_REQUEST_BLANK)
    String countryName;

    public CoronaRequestDto(String beginDate, String endDate,String countryName){
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.countryName = countryName;
    }
}
