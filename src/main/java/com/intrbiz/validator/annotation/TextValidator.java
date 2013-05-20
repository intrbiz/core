package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorText;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@ValidatorType(validator=ValidatorText.class)
public @interface TextValidator {
    boolean mandatory() default false ;
    int minLength() default 0;
    int maxLength() default Integer.MAX_VALUE;
}
