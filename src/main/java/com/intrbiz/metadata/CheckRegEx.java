package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.StringConverter;
import com.intrbiz.validator.validators.RegexValidator;

/**
 * Check that the value matches the given RegEx
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(RegexValidator.class)
@UseConverter(StringConverter.class)
public @interface CheckRegEx {
    String value() default ".*" ;
}
