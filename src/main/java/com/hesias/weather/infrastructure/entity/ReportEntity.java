package com.hesias.weather.infrastructure.entity;

import com.hesias.weather.domain.model.Coordinate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "report")
public class ReportEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Coordinate coordinate;

    @ManyToOne
    private WeatherEntity weather;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date date;

    private Float temperature;

}
