package com.dev.springrestapi.util.res;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class StringToLocalDateTime {
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    public StringToLocalDateTime(String beginDate, String endDate) {
        this.beginDate = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.endDate = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

//    public StringToLocalDateTime(String beg   inDate) {
//        this.beginDate = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        this.endDate = LocalDateTime.now();
//    }
}
