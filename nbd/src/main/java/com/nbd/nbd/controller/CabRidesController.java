package com.nbd.nbd.controller;

import com.nbd.nbd.model.CabRides;
import com.nbd.nbd.repository.CabRidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CabRidesController {

    @Autowired
    CabRidesRepository cabRidesRepository;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck() {
        return "{ \"isWorking\" : true }";
    }

    @GetMapping("/cab_rides")
    public List<CabRides> getCabRidesList()
    {
        Iterable<CabRides> result = cabRidesRepository.findAll();
        List<CabRides> cabRidesList = new ArrayList<CabRides>();
        result.forEach(cabRidesList::add);
        return cabRidesList;
    }

    @PostMapping(value = "/cab_rides", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CabRides addCabRides(@RequestBody CabRides cabRides) {
        String id = UUID.randomUUID().toString();
        cabRides.setId(id);
        cabRidesRepository.save(cabRides);
        return cabRides;
    }
    @GetMapping(value = "/cab_rides/{id}")
    public Optional<CabRides> getCabRides(@PathVariable String id){
        Optional<CabRides> emp = cabRidesRepository.findById(id);
        return emp;
    }
    @PutMapping("/cab_rides/{id}")
    public Optional<CabRides> updateEmployee(@RequestBody CabRides cabRide, @PathVariable String id)
    {
        Optional<CabRides> optionalEmp = cabRidesRepository.findById(id);
        if (optionalEmp.isPresent()) {
            CabRides emp = optionalEmp.get();
            emp.setCabType(cabRide.getCabType());
            emp.setDestination(cabRide.getDestination());
            emp.setDistance(cabRide.getDistance());
            emp.setName(cabRide.getName());
            emp.setProductId(cabRide.getProductId());
            emp.setSurgeMultiplier(cabRide.getSurgeMultiplier());
            emp.setTimestamp(cabRide.getTimestamp());
            emp.setSource(cabRide.getSource());
            emp.setProductId(cabRide.getProductId());

            cabRidesRepository.save(emp);
        }
        return optionalEmp;
    }

    @DeleteMapping(value = "/cab_rides/{id}", produces = "application/json; charset=utf-8")
    public String deleteById(@PathVariable String id) {
        Boolean result = cabRidesRepository.existsById(id);
        cabRidesRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";
    }
}

