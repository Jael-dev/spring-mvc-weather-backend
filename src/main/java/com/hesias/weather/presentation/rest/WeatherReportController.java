package com.hesias.weather.presentation.rest;

import com.hesias.weather.application.ReportService;
import com.hesias.weather.domain.model.ReportRequest;
import com.hesias.weather.domain.model.ReportResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("/weather")
public class WeatherReportController {


    private final ReportService reportService;

    public WeatherReportController(
            ReportService reportService

    ) {
        super();
        this.reportService = reportService;

    }

    @PostMapping("/report")
    public ReportResponse create(@RequestBody ReportRequest reportRequest) {
        return reportService.createReport(reportRequest);
    }

    @GetMapping("/report")
    public List<ReportResponse> getReports() {
        return reportService.getAllReports();
    }

    @PutMapping("/report/{id}")
    public ReportResponse update(@PathVariable Long id, @RequestBody ReportRequest reportRequest) {
        return reportService.updateReport(id, reportRequest);
    }

    @DeleteMapping("/report/{id}")
    public void delete(@PathVariable Long id) {
        reportService.deleteReport(id);
    }

    @GetMapping("/reports")
    public List<ReportResponse> getReports(@RequestParam Double latitude,
                                           @RequestParam Double longitude,
                                           @RequestParam Double radius
    ) {
        return reportService.getReportsInRadius(latitude, longitude, radius / 1000);
    }
}
