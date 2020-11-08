package com.dev.springrestapi.finedust.dto.request.airdata;

import com.dev.springrestapi.finedust.util.Strings;
import com.dev.springrestapi.finedust.util.customvalid.airdata.valid.DateFormatValid;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class AirDataRequestDto {
    @DateFormatValid
    String beginDate;
    @DateFormatValid
    String endDate;
    @NotBlank(message = Strings.CAN_NOT_REQUEST_BLANK)
    String stationName;

    public AirDataRequestDto(String beginDate, String endDate, String stationName) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.stationName = stationName;
    }
}
