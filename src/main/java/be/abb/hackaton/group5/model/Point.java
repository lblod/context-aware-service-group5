package be.abb.hackaton.group5.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Point {

    @JsonProperty("geo:lat")
    private double latitude;

    @JsonProperty("geo:long")
    private double longitude;

    // Constructors, getters, and setters
    public Point() {}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
