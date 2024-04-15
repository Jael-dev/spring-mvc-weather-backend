package com.hesias.weather.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate() {
        super();
    }

    public Coordinate(double latitude, double longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
