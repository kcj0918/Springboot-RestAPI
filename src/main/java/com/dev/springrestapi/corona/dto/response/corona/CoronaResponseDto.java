package com.dev.springrestapi.corona.dto.response.corona;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CoronaResponseDto {

    private String countryName;
    private int newCase;
    private int totalCase;
    private int recovered;
    private int death;
    private float percentage;
    private int newCcase;
    private int newFcase;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    public CoronaResponseDto(String countryName,
                             int newCase,
                             int totalCase,
                             int recovered,
                             int death,
                             float percentage,
                             int newCcase,
                             int newFcase,
                             LocalDateTime createDt,
                             LocalDateTime updateDt){
        this.countryName = countryName;
        this.newCase = newCase;
        this.totalCase = totalCase;
        this.recovered = recovered;
        this.death = death;
        this.percentage = percentage;
        this.newCcase = newCcase;
        this.newFcase = newFcase;
        this.createDt = createDt;
        this.updateDt = updateDt;
    }
}
