package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.LongConverter;
import com.intrbiz.validator.validators.LongValidator;

/**
 * Check the range of a long value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(LongValidator.class)
@UseConverter(LongConverter.class)
public @interface IsaLong {
    long min() default Long.MIN_VALUE;
    long max() default Long.MAX_VALUE;
}
