package com.hesias.weather.domain.annotation;

import com.hesias.weather.domain.validator.LatitudeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Constraint(validatedBy = {LatitudeValidator.class})
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLatitude {
    String message() default "Invalid latitude";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}