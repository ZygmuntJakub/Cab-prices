package com.nbd.nbd.controller;

import com.nbd.nbd.model.CabRides;
import com.nbd.nbd.model.Weather;
import com.nbd.nbd.model.WeatherKey;
import com.nbd.nbd.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping("/weather")
    public List<Weather> getWeathers()
    {
        Iterable<Weather> result = weatherRepository.findAll();
        List<Weather> weatherList = new ArrayList<Weather>();
        result.forEach(weatherList::add);
        return weatherList;
    }

    @PostMapping(value = "/weather", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Weather addWeather(@RequestBody Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }
    @GetMapping(value = "/weather/{location}-{timestamp}")
    public Optional<Weather> getCabRides(@PathVariable String location, @PathVariable Long timestamp){
        Optional<Weather> emp = weatherRepository.findById(new WeatherKey(location, timestamp));
        return emp;
    }
    @PutMapping("/weather/{location}-{timestamp}")
    public Optional<Weather> updateEmployee(@RequestBody Weather weather, @PathVariable String location, @PathVariable Long timestamp)
    {
        Optional<Weather> optionalEmp = weatherRepository.findById(new WeatherKey(location,timestamp));
        if (optionalEmp.isPresent()) {
            Weather emp = optionalEmp.get();
            emp.setClouds(weather.getClouds());
            emp.setHumidity(weather.getHumidity());
            emp.setPressure(weather.getPressure());
            emp.setRain(weather.getRain());
            emp.setWind(weather.getWind());

            weatherRepository.save(emp);
        }
        return optionalEmp;
    }

    @DeleteMapping(value = "/weather/{location}-{timestamp}", produces = "application/json; charset=utf-8")
    public String deleteById(@PathVariable String location, @PathVariable Long timestamp) {
        WeatherKey weatherKey = new WeatherKey(location, timestamp);
        Boolean result = weatherRepository.existsById(weatherKey);
        weatherRepository.deleteById(weatherKey);
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";
    }

}
