package com.dev.springrestapi.corona.dto.response.corona;

import lombok.Builder;

import java.util.List;

@Builder
public class GetCoronaResponseDto {
    List<CoronaResponseDto> coronaResponseDto;
}
