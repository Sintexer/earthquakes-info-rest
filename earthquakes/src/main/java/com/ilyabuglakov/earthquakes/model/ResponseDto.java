package com.ilyabuglakov.earthquakes.model;

import java.util.List;

public class ResponseDto {
    long lowMagnitudes;
    long HighMagnitudes;
    List<Earthquake> earthquakes;

    public ResponseDto(long lowMagnitudes, long highMagnitudes, List<Earthquake> earthquakes) {
        this.lowMagnitudes = lowMagnitudes;
        HighMagnitudes = highMagnitudes;
        this.earthquakes = earthquakes;
    }

    public long getLowMagnitudes() {
        return lowMagnitudes;
    }

    public void setLowMagnitudes(long lowMagnitudes) {
        this.lowMagnitudes = lowMagnitudes;
    }

    public long getHighMagnitudes() {
        return HighMagnitudes;
    }

    public void setHighMagnitudes(long highMagnitudes) {
        HighMagnitudes = highMagnitudes;
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }
}
