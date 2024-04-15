package com.hesias.weather.domain.model;

import com.hesias.weather.domain.annotation.ValidLatitude;
import com.hesias.weather.domain.annotation.ValidLongitude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ReportRequest implements Serializable {
    @ValidLatitude
    private double latitude;

    @ValidLongitude
    private Double longitude;

    private Float temperature;

    @NotEmpty
    private String weather;

    public ReportRequest() {
        super();
    }

    public ReportRequest(double latitude, double longitude, Float temperature, String weather) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.weather = weather;
    }

}