package com.hesias.weather.application;

import com.hesias.weather.domain.mapper.ReportRequestMapper;
import com.hesias.weather.domain.mapper.ReportResponseMapper;
import com.hesias.weather.domain.model.Coordinate;
import com.hesias.weather.domain.model.ReportRequest;
import com.hesias.weather.domain.model.ReportResponse;
import com.hesias.weather.infrastructure.entity.ReportEntity;
import com.hesias.weather.infrastructure.entity.WeatherEntity;
import com.hesias.weather.infrastructure.repository.ReportRepository;
import com.hesias.weather.infrastructure.repository.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportRequestMapper reportRequestMapper;
    private final ReportResponseMapper reportResponseMapper;
    private final WeatherRepository weatherRepository;

    public ReportService(ReportRepository reportRepository, ReportRequestMapper reportRequestMapper, ReportResponseMapper reportResponseMapper, WeatherRepository weatherRepository) {
        this.reportRepository = reportRepository;
        this.reportRequestMapper = reportRequestMapper;
        this.reportResponseMapper = reportResponseMapper;
        this.weatherRepository = weatherRepository;
    }

    public ReportResponse createReport(ReportRequest report) {
        ReportEntity reportEntity = reportRequestMapper.convertToEntity(report);
        reportRepository.save(reportEntity);
        return reportResponseMapper.convertToDto(reportEntity);
    }

    public List<ReportResponse> getReportsInRadius(Double userLatitude, Double userLongitude, Double radius) {
        return reportRepository.findWithinRadiusAndToday(userLatitude, userLongitude, radius).stream()
                .map(reportResponseMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<ReportResponse> getAllReports() {
        return reportRepository.findAll().stream()
                .map(reportResponseMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public ReportResponse updateReport(Long id, ReportRequest reportRequest) {
        ReportEntity reportEntity = reportRepository.findById(id).orElseThrow();
        Coordinate coordinate = new Coordinate(reportRequest.getLatitude(), reportRequest.getLongitude());
        reportEntity.setCoordinate(coordinate);
        reportEntity.setTemperature(reportRequest.getTemperature());
        WeatherEntity weather = weatherRepository.findOneByLabel(reportRequest.getWeather());
       reportEntity.setWeather(weather);
        reportRepository.save(reportEntity);
        return reportResponseMapper.convertToDto(reportEntity);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}