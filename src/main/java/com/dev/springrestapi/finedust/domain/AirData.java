package com.dev.springrestapi.finedust.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = ("tblAirData"))
@Getter
@NoArgsConstructor
public class AirData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("seq"))
    private Long seq;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = ("dataTime"))
    private LocalDateTime dataTime;

    @Column(name = ("so2Value"))
    private Double so2Value;

    @Column(name = ("coValue"))
    private Double coValue;

    @Column(name = ("o3Value"))
    private Double o3Value;

    @Column(name = ("no2Value"))
    private Double no2Value;

    @Column(name = ("pm10Value"))
    private Double pm10Value;

    @Column(name = ("pm10value24"))
    private Double pm10value24;

    @Column(name = ("pm25Value"))
    private Double pm25Value;

    @Column(name = ("pm25Value24"))
    private Double pm25Value24;

    @Column(name = ("khaiValue"))
    private Double khaiValue;

    @Column(name = ("khaiGrade"))
    private Double khaiGrade;

    @Column(name = ("so2Grade"))
    private Double so2Grade;

    @Column(name = ("coGrade"))
    private Double coGrade;

    @Column(name = ("o3Grade"))
    private Double o3Grade;

    @Column(name = ("no2Grade"))
    private Double no2Grade;

    @Column(name = ("pm10Grade"))
    private Double pm10Grade;

    @Column(name = ("pm25Grade"))
    private Double pm25Grade;

    @Column(name = ("pm10Grade1h"))
    private Double pm10Grade1h;

    @Column(name = ("pm25Grade1h"))
    private Double pm25Grade1h;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = ("regdate"))
    private LocalDateTime regdate;

    @Column(name = ("stationName"))
    private String stationName;

    @Builder
    public AirData(Long seq,
                   LocalDateTime dataTime,
                   Double so2Value,
                   Double coValue,
                   Double o3Value,
                   Double no2Value,
                   Double pm10Value,
                   Double pm10value24,
                   Double pm25Value,
                   Double pm25Value24,
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
                   LocalDateTime regdate,
                   String stationName) {
        this.seq = seq;
        this.dataTime = dataTime;
        this.so2Value = so2Value;
        this.coValue = coValue;
        this.o3Value = o3Value;
        this.no2Value = no2Value;
        this.pm10Value = pm10Value;
        this.pm10value24 = pm10value24;
        this.pm25Value = pm25Value;
        this.pm25Value24 = pm25Value24;
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
        this.regdate = regdate;
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "{" +
                "seq=" + seq +
                ", dataTime=" + dataTime +
                ", so2Value=" + so2Value +
                ", coValue=" + coValue +
                ", o3Value=" + o3Value +
                ", no2Value=" + no2Value +
                ", pm10Value=" + pm10Value +
                ", pm10value24=" + pm10value24 +
                ", pm25Value=" + pm25Value +
                ", pm25Value24=" + pm25Value24 +
                ", khaiValue=" + khaiValue +
                ", khaiGrade=" + khaiGrade +
                ", so2Grade=" + so2Grade +
                ", coGrade=" + coGrade +
                ", o3Grade=" + o3Grade +
                ", no2Grade=" + no2Grade +
                ", pm10Grade=" + pm10Grade +
                ", pm25Grade=" + pm25Grade +
                ", pm10Grade1h=" + pm10Grade1h +
                ", pm25Grade1h=" + pm25Grade1h +
                ", regdate=" + regdate +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
