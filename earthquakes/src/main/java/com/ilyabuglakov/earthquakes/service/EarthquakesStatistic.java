package com.ilyabuglakov.earthquakes.service;

import com.ilyabuglakov.earthquakes.model.Earthquake;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EarthquakesStatistic {

    public long magnitudeLesserThan(List<Earthquake> earthquakes, double magnitude){
        return earthquakes.stream().filter( earthquake -> {
            if (earthquake.getMagnitude() < magnitude)
                return true;
            return false;
        }).count();
    }

    public long magnitudeHigherEqualThan(List<Earthquake> earthquakes, double magnitude){
        return earthquakes.stream().filter( earthquake -> {
            if (earthquake.getMagnitude() >= magnitude)
                return true;
            return false;
        }).count();
    }
}
