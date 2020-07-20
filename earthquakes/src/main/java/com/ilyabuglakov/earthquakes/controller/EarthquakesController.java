package com.ilyabuglakov.earthquakes.controller;

import com.ilyabuglakov.earthquakes.service.EarthquakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("earthquakes")
public class EarthquakesController {

    @Autowired
    private EarthquakesService service;

    @RequestMapping("recent")
    public ResponseEntity<?> recentEarthquakes() {
        return ResponseEntity.ok(service.formResponse());
    }

    @RequestMapping("significant")
    public ResponseEntity<?> strongEarthquakes(){
        return ResponseEntity.ok(service.getSignificant());
    }

}
