package com.hesias.weather.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class ReportResponse implements Serializable {

    private Float temperature;
    private Coordinate coordinate;

    private Date date;

    private String weather;

    public ReportResponse() {
        super();
    }

    public ReportResponse(Float temperature, String weather) {
        super();
        this.temperature = temperature;
        this.weather = weather;
    }


}