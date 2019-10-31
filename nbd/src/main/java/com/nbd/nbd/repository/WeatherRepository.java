package com.nbd.nbd.repository;

import com.nbd.nbd.model.Weather;
import com.nbd.nbd.model.WeatherKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CassandraRepository<Weather, WeatherKey> {
}
