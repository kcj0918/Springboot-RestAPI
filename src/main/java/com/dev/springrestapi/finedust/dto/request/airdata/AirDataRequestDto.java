package com.dev.springrestapi.finedust.dto.request.airdata;

import com.dev.springrestapi.finedust.util.customvalid.airdata.valid.DateValid;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AirDataRequestDto {
    @DateValid
    String beginDate;
    @DateValid
    String endDate;
    String stationName;

    public AirDataRequestDto(String beginDate, String endDate, String stationName) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.stationName = stationName;
    }
}
