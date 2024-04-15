package com.hesias.weather.domain.mapper;

import com.hesias.weather.domain.model.Coordinate;
import com.hesias.weather.domain.model.ReportRequest;
import com.hesias.weather.infrastructure.entity.ReportEntity;
import com.hesias.weather.infrastructure.entity.WeatherEntity;
import com.hesias.weather.infrastructure.repository.WeatherRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ReportRequestMapper {

    private final WeatherRepository weatherRepository;

    public ReportRequestMapper(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public ReportEntity convertToEntity(ReportRequest dto) {
        ReportEntity report = new ReportEntity();
        Coordinate coordinate = new Coordinate(dto.getLatitude(), dto.getLongitude());
        report.setCoordinate(coordinate);
        report.setDate(new Date());
        report.setTemperature(dto.getTemperature());
        WeatherEntity weather = weatherRepository.findOneByLabel(dto.getWeather());
        if (weather == null) {
            List<WeatherEntity> weathers = weatherRepository.findAll();
            throw new IllegalArgumentException("Weather : " + dto.getWeather() + " not found. Available weathers are : " + weathers);
        }
        report.setWeather(weather);
        return report;
    }

    public ReportRequest convertToDto(ReportRequest entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}