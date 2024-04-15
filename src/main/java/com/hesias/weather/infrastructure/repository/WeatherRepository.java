package com.hesias.weather.infrastructure.repository;

import com.hesias.weather.infrastructure.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    WeatherEntity findOneByLabel(String label);

}
