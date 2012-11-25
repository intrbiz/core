package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorDate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValidatorType(validator=ValidatorDate.class)
public @interface DateValidator {

    boolean mandatory() default false ;
    long min() default Long.MAX_VALUE;
    long max() default Long.MIN_VALUE;
}
