package com.dev.springrestapi.corona.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCorona is a Querydsl query type for Corona
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCorona extends EntityPathBase<Corona> {

    private static final long serialVersionUID = 859632015L;

    public static final QCorona corona = new QCorona("corona");

    public final StringPath countryName = createString("countryName");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> death = createNumber("death", Integer.class);

    public final NumberPath<Integer> newCase = createNumber("newCase", Integer.class);

    public final NumberPath<Integer> newCcase = createNumber("newCcase", Integer.class);

    public final NumberPath<Integer> newFcase = createNumber("newFcase", Integer.class);

    public final NumberPath<Float> percentage = createNumber("percentage", Float.class);

    public final NumberPath<Integer> recovered = createNumber("recovered", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final NumberPath<Integer> totalCase = createNumber("totalCase", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateDt = createDateTime("updateDt", java.time.LocalDateTime.class);

    public QCorona(String variable) {
        super(Corona.class, forVariable(variable));
    }

    public QCorona(Path<? extends Corona> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCorona(PathMetadata metadata) {
        super(Corona.class, metadata);
    }

}

