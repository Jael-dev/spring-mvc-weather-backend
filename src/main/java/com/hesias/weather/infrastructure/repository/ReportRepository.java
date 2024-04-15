package com.hesias.weather.infrastructure.repository;

import com.hesias.weather.infrastructure.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    @Query("SELECT r, (6371 * ACOS( COS(RADIANS(:givenLatitude)) * COS(RADIANS(r.coordinate.latitude)) * COS(RADIANS(r.coordinate.longitude) - RADIANS(:givenLongitude)) + SIN(RADIANS(:givenLatitude)) * SIN(RADIANS(r.coordinate.latitude)) ) ) AS distance FROM ReportEntity r WHERE (6371 * ACOS( COS(RADIANS(:givenLatitude)) * COS(RADIANS(r.coordinate.latitude)) * COS(RADIANS(r.coordinate.longitude) - RADIANS(:givenLongitude)) + SIN(RADIANS(:givenLatitude)) * SIN(RADIANS(r.coordinate.latitude)) ) ) <= :kmRadius ORDER BY  r.date DESC")
    List<ReportEntity>  findWithinRadiusAndToday(@Param("givenLatitude") Double givenLatitude,
                                          @Param("givenLongitude") Double givenLongitude,
                                          @Param("kmRadius") Double kmRadius);
    //List<ReportEntity> findWithinRadiusAndToday(Double userLatitude, Double userLongitude, Double radius);

    @Query(value = "SELECT * FROM Report r WHERE " +
            "sdo_geom.sdo_distance(" +
            "sdo_geometry(2001, 4326, sdo_point_type(?1, ?2, null), null, null)," +
            "sdo_geometry(2001, 4326, sdo_point_type(r.latitude, r.longitude, null), null, null)," +
            "0.01," +
            "'unit=KM'"+
            ") <= ?3 " +
            "AND trunc(r.timestamp) = ?4", nativeQuery = true)
    List<ReportEntity> findNearbyReports(Double userLatitude, Double userLongitude, Double radius, LocalDate date);

}
