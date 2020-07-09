package com.ilyabuglakov.earthquakes.model;

public class Earthquake {
    private Location location;
    private String title;
    private double depth;
    private double magnitude;

    public Earthquake(double lat, double lon, String title, double depth, double magnitude) {
        this.location = new Location(lat, lon);
        this.title = title;
        this.depth = depth;
        this.magnitude = magnitude;
    }

    public Location getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public double getDepth() {
        return depth;
    }

    public double getMagnitude() {
        return magnitude;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "location=" + location +
                ", title='" + title + '\'' +
                ", depth=" + depth +
                ", magnitude=" + magnitude +
                '}';
    }
}
