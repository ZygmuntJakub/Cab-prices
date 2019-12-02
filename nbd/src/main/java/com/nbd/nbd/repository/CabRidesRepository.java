package com.nbd.nbd.repository;


import com.nbd.nbd.model.CabRides;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRidesRepository extends CassandraRepository<CabRides, String> {

}

