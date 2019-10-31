package com.nbd.nbd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@Table("cab_rides")
public class CabRides {

    private @NonNull Double distance;

    @Column("cab_type")
    private @NonNull String cabType;

    @Column("time_stamp")
    private @NonNull Long timestamp;

    private @NonNull String destination;

    private @NonNull String source;

    private Double price;

    @Column("surge_multiplier")
    private @NonNull Double surgeMultiplier;

    @PrimaryKey
    private  @NonNull String id;

    @Column("product_id")
    private @NonNull String productId;
    private @NonNull String name;


}
