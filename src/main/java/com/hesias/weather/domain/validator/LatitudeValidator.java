package com.hesias.weather.domain.validator;

import com.hesias.weather.domain.annotation.ValidLatitude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LatitudeValidator implements ConstraintValidator<ValidLatitude, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value >= -90 && value <= 90;
    }

    @Override
    public void initialize(ValidLatitude constraintAnnotation) {
    }
}
