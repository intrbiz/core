package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.StringConverter;
import com.intrbiz.validator.validators.TextValidator;

/**
 * Validate the length of a String
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(TextValidator.class)
@UseConverter(StringConverter.class)
public @interface CheckStringLength {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
