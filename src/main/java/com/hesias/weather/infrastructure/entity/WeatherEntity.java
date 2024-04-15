package com.hesias.weather.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "weather")
public class WeatherEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String label;

    private String icon;

    public WeatherEntity() {
        super();
    }

}