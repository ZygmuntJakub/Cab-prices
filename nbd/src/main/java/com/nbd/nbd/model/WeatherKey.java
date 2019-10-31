package com.nbd.nbd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyClass
public class WeatherKey {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String location;

    @PrimaryKeyColumn(name = "time_stamp", ordinal = 0)
    private Long timestamp;
}
