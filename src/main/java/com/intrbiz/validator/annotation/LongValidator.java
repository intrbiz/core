package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorLong;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@ValidatorType(validator=ValidatorLong.class)
public @interface LongValidator {
    boolean mandatory() default false ;
    long min() default Long.MIN_VALUE;
    long max() default Long.MAX_VALUE;
}
