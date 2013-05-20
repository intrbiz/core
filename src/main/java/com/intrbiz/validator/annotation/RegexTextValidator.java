package com.intrbiz.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.validators.ValidatorTextRegex;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@ValidatorType(validator=ValidatorTextRegex.class)
public @interface RegexTextValidator {
    boolean mandatory() default false ;
    String pattern() default ".*" ;
}
