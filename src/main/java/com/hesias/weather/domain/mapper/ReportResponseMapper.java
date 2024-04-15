package com.hesias.weather.domain.mapper;

import com.hesias.weather.domain.model.Coordinate;
import com.hesias.weather.domain.model.ReportResponse;
import com.hesias.weather.infrastructure.entity.ReportEntity;
import com.hesias.weather.infrastructure.entity.WeatherEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReportResponseMapper {

    public ReportResponse convertToDto(ReportEntity entity) {
        ReportResponse report = new ReportResponse();
        Coordinate coordinate = new Coordinate(entity.getCoordinate().getLatitude(), entity.getCoordinate().getLongitude());
        report.setCoordinate(coordinate);
        report.setDate(new Date());
        report.setTemperature(entity.getTemperature());
        WeatherEntity weather = entity.getWeather();
        report.setWeather(weather.getLabel());
        return report;
    }
}