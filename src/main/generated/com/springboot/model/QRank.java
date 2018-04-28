package com.springboot.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRank is a Querydsl query type for Rank
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRank extends EntityPathBase<Rank> {

    private static final long serialVersionUID = 1051594259L;

    public static final QRank rank1 = new QRank("rank1");

    public final ListPath<AppUser, QAppUser> appUsers = this.<AppUser, QAppUser>createList("appUsers", AppUser.class, QAppUser.class, PathInits.DIRECT2);

    public final StringPath lastUpdatedBy = createString("lastUpdatedBy");

    public final DateTimePath<java.util.Date> lastUpdatedDate = createDateTime("lastUpdatedDate", java.util.Date.class);

    public final StringPath rank = createString("rank");

    public final NumberPath<Integer> rankId = createNumber("rankId", Integer.class);

    public QRank(String variable) {
        super(Rank.class, forVariable(variable));
    }

    public QRank(Path<? extends Rank> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRank(PathMetadata<?> metadata) {
        super(Rank.class, metadata);
    }

}

