package com.dev.springrestapi.corona.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
    @Entity : jpa 관리하는 클래스
    @Column(name : ~~ )  :실제 테이블과 매핑되는 이름

*/

@Entity
@Table(name = ("corona_summary"))
@Getter
@NoArgsConstructor
public class Corona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("seq"))
    private Long seq;

    @Column(name = ("countryName"))
    private String countryName;        //지역명

    @Column(name = ("newCase"))
    private int newCase;              //신규 확진자

    @Column(name = ("totalCase"))
    private int totalCase;            //국내 확진자수

    @Column(name = ("recovered"))
    private int recovered;            //국내 완치자수

    @Column(name = ("death"))
    private int death;                //사망자

    @Column(name = ("percentage"))
    private float percentage;         //발생율

    @Column(name = ("newCcase"))
    private int newCcase;             //전일대비증감-지역발생

    @Column(name = ("newFcase"))
    private int newFcase;             //전일대비증감-해외유입

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = ("create_dt"))
    private LocalDateTime createDt;   //작업일자

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = ("update_dt"))
    private LocalDateTime updateDt;   //수정일자

    @Builder
    public Corona(Long seq,
                  String countryName,
                  int newCase,
                  int totalCase,
                  int recovered,
                  int death,
                  float percentage,
                  int newCcase,
                  int newFcase,
                  LocalDateTime createDt,
                  LocalDateTime updateDt){
        this.seq = seq;
        this.countryName =countryName;
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

    @Override
    public String toString() {
        return "{" +
                "seq=" + seq +
                ", countryName=" + countryName +
                ", newCase=" + newCase +
                ", totalCase=" + totalCase +
                ", recovered=" + recovered +
                ", death=" + death +
                ", percentage=" + percentage +
                ", newCcase=" + newCcase +
                ", newFcase=" + newFcase +
                ", createDt=" + createDt +
                ", updateDt=" + updateDt+ '\'' +
                '}';
    }
}
