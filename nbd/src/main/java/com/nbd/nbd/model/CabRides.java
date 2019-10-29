package com.nbd.nbd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@Table
public class CabRides {

    private @NonNull Double distance;
    private @NonNull String cabType;
    private @NonNull Timestamp timestamp;
    private @NonNull String destination;
    private @NonNull String source;
    private @NonNull Double price;
    private @NonNull Double surgeMultiplier;
    @PrimaryKey
    private  @NonNull String id;
    private @NonNull String productId;
    private @NonNull String name;


}
