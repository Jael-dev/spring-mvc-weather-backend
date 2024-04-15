package com.hesias.weather.domain.validator;

import com.hesias.weather.domain.annotation.ValidLongitude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LongitudeValidator implements ConstraintValidator<ValidLongitude, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value >= -180 && value <= 180;
    }

    @Override
    public void initialize(ValidLongitude constraintAnnotation) {
    }
}
