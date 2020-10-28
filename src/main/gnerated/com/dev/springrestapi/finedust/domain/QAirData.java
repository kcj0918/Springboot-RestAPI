package com.dev.springrestapi.finedust.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAirData is a Querydsl query type for AirData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAirData extends EntityPathBase<AirData> {

    private static final long serialVersionUID = -966619023L;

    public static final QAirData airData = new QAirData("airData");

    public final NumberPath<Double> coGrade = createNumber("coGrade", Double.class);

    public final StringPath dataTime = createString("dataTime");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Double> khaiGrade = createNumber("khaiGrade", Double.class);

    public final NumberPath<Double> khaiValue = createNumber("khaiValue", Double.class);

    public final NumberPath<Double> no2Grade = createNumber("no2Grade", Double.class);

    public final NumberPath<Double> no2Value = createNumber("no2Value", Double.class);

    public final NumberPath<Double> o3Grade = createNumber("o3Grade", Double.class);

    public final NumberPath<Double> o3Value = createNumber("o3Value", Double.class);

    public final NumberPath<Double> pm10Grade = createNumber("pm10Grade", Double.class);

    public final NumberPath<Double> pm10Grade1h = createNumber("pm10Grade1h", Double.class);

    public final NumberPath<Double> pm10Value = createNumber("pm10Value", Double.class);

    public final NumberPath<Double> pm10value24 = createNumber("pm10value24", Double.class);

    public final NumberPath<Double> pm25Grade = createNumber("pm25Grade", Double.class);

    public final NumberPath<Double> pm25Grade1h = createNumber("pm25Grade1h", Double.class);

    public final NumberPath<Double> so2Grade = createNumber("so2Grade", Double.class);

    public final NumberPath<Double> so2Value = createNumber("so2Value", Double.class);

    public final StringPath stationName = createString("stationName");

    public QAirData(String variable) {
        super(AirData.class, forVariable(variable));
    }

    public QAirData(Path<? extends AirData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAirData(PathMetadata metadata) {
        super(AirData.class, metadata);
    }

}

