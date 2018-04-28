package com.springboot.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTrainingstatus is a Querydsl query type for Trainingstatus
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTrainingstatus extends EntityPathBase<Trainingstatus> {

    private static final long serialVersionUID = 1449073267L;

    public static final QTrainingstatus trainingstatus = new QTrainingstatus("trainingstatus");

    public final SetPath<AppUser, QAppUser> appUsers = this.<AppUser, QAppUser>createSet("appUsers", AppUser.class, QAppUser.class, PathInits.DIRECT2);

    public final StringPath lastUpdatedBy = createString("lastUpdatedBy");

    public final DateTimePath<java.util.Date> lastUpdatedDate = createDateTime("lastUpdatedDate", java.util.Date.class);

    public final StringPath trainingStatus = createString("trainingStatus");

    public final NumberPath<Integer> trainingStatusId = createNumber("trainingStatusId", Integer.class);

    public QTrainingstatus(String variable) {
        super(Trainingstatus.class, forVariable(variable));
    }

    public QTrainingstatus(Path<? extends Trainingstatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrainingstatus(PathMetadata<?> metadata) {
        super(Trainingstatus.class, metadata);
    }

}

