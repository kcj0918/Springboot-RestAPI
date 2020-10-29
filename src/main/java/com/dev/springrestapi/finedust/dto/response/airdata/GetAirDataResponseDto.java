package com.dev.springrestapi.finedust.dto.response.airdata;

import lombok.Builder;

import java.util.List;

@Builder
public class GetAirDataResponseDto {
    List<AirDataResponseDto> airDataResponseDto;
}
