package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorUUID;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValidatorType(validator=ValidatorUUID.class)
public @interface UUIDValidator {
    boolean mandatory() default false ;
}
