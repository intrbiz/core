package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorFloat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValidatorType(validator=ValidatorFloat.class)
public @interface FloatValidator {
    boolean mandatory() default false ;
    float min() default Float.MIN_VALUE;
    float max() default Float.MAX_VALUE;
}
