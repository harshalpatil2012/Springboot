package com.springboot.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAppUser is a Querydsl query type for AppUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAppUser extends EntityPathBase<AppUser> {

    private static final long serialVersionUID = -1218805179L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppUser appUser = new QAppUser("appUser");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final QRank rank;

    public final NumberPath<Double> salary = createNumber("salary", Double.class);

    public final QTrainingstatus trainingstatus;

    public QAppUser(String variable) {
        this(AppUser.class, forVariable(variable), INITS);
    }

    public QAppUser(Path<? extends AppUser> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAppUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAppUser(PathMetadata<?> metadata, PathInits inits) {
        this(AppUser.class, metadata, inits);
    }

    public QAppUser(Class<? extends AppUser> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.rank = inits.isInitialized("rank") ? new QRank(forProperty("rank")) : null;
        this.trainingstatus = inits.isInitialized("trainingstatus") ? new QTrainingstatus(forProperty("trainingstatus")) : null;
    }

}

