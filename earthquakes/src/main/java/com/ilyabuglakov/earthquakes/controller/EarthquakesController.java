package com.ilyabuglakov.earthquakes.controller;

import com.ilyabuglakov.earthquakes.service.EarthquakesParser;
import com.ilyabuglakov.earthquakes.service.EarthquakesService;
import com.ilyabuglakov.earthquakes.service.EarthquakesStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class EarthquakesController {

    @Autowired
    private EarthquakesService service;

    @RequestMapping("/earthquakes")
    public ResponseEntity<?> recentEarthquakes() {
        //return ResponseEntity.ok("All good");
        return ResponseEntity.ok(service.formResponse());
    }

}
