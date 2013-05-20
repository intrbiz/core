package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorDouble;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@ValidatorType(validator=ValidatorDouble.class)
public @interface DoubleValidator {
    boolean mandatory() default false ;
    double min() default Double.MIN_VALUE;
    double max() default Double.MAX_VALUE;
}
