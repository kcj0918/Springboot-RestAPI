package com.dev.springrestapi.finedust.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class AirData {
    @Id
    @GeneratedValue
    private Long idx;

    private LocalDateTime dataTime;

    private Double so2Value;

    private Double o3Value;

    private Double no2Value;

    private Double pm10Value;

    private Double pm10value24;

    private Double khaiValue;

    private Double khaiGrade;

    private Double so2Grade;

    private Double coGrade;

    private Double o3Grade;

    private Double no2Grade;

    private Double pm10Grade;

    private Double pm25Grade;

    private Double pm10Grade1h;

    private Double pm25Grade1h;

    private String stationName;

    @Builder
    public AirData(Long idx,
                   LocalDateTime dataTime,
                   Double so2Value,
                   Double o3Value,
                   Double no2Value,
                   Double pm10Value,
                   Double pm10value24,
                   Double khaiValue,
                   Double khaiGrade,
                   Double so2Grade,
                   Double coGrade,
                   Double o3Grade,
                   Double no2Grade,
                   Double pm10Grade,
                   Double pm25Grade,
                   Double pm10Grade1h,
                   Double pm25Grade1h,
                   String stationName) {
        this.idx = idx;
        this.dataTime = dataTime;
        this.so2Value = so2Value;
        this.o3Value = o3Value;
        this.no2Value = no2Value;
        this.pm10Value = pm10Value;
        this.pm10value24 = pm10value24;
        this.khaiValue = khaiValue;
        this.khaiGrade = khaiGrade;
        this.so2Grade = so2Grade;
        this.coGrade = coGrade;
        this.o3Grade = o3Grade;
        this.no2Grade = no2Grade;
        this.pm10Grade = pm10Grade;
        this.pm25Grade = pm25Grade;
        this.pm10Grade1h = pm10Grade1h;
        this.pm25Grade1h = pm25Grade1h;
        this.stationName = stationName;
    }
}
