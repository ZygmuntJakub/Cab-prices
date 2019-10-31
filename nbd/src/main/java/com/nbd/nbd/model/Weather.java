package com.nbd.nbd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@Getter
@Setter
@Table("weather")
public class Weather {

    @PrimaryKey("id")
    private WeatherKey id;
    private @NonNull Double temp;
    private @NonNull Double clouds;
    private @NonNull Double pressure;
    private Double rain;

    private @NonNull Double humidity;
    private @NonNull Double wind;



}
