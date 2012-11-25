package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorEmail;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValidatorType(validator=ValidatorEmail.class)
public @interface EmailValidator {
    boolean mandatory() default false ;
}
