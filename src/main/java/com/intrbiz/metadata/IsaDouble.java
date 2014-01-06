package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.DoubleConverter;
import com.intrbiz.validator.validators.DoubleValidator;

/**
 * Check the range of a double value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(DoubleValidator.class)
@UseConverter(DoubleConverter.class)
public @interface IsaDouble {
    double min() default Double.MIN_VALUE;
    double max() default Double.MAX_VALUE;
}
