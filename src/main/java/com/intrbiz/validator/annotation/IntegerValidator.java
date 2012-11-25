package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorInteger;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValidatorType(validator=ValidatorInteger.class)
public @interface IntegerValidator {
    boolean mandatory() default false ;
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
}
