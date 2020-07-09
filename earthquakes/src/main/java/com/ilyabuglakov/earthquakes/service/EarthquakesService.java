package com.ilyabuglakov.earthquakes.service;

import com.ilyabuglakov.earthquakes.model.ResponseDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarthquakesService {

    @Autowired
    private EarthquakesParser parser;
    @Autowired
    private EarthquakesStatistic statistic;

    public ResponseDto formResponse(){
        List earthquakes = parser.parseRecent();
        return new ResponseDto(
                statistic.magnitudeLesserThan(earthquakes, 5),
                statistic.magnitudeHigherEqualThan(earthquakes, 5),
                earthquakes
        );
    }

}
