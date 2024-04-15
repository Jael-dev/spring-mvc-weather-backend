package com.hesias.weather.domain.annotation;

import com.hesias.weather.domain.validator.LongitudeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;



@Constraint(validatedBy = {LongitudeValidator.class})
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLongitude {
    String message() default "Invalid longitude";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}