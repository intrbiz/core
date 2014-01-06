package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.IntegerConverter;
import com.intrbiz.validator.validators.IntegerValidator;

/**
 * Check the range of a int value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(IntegerValidator.class)
@UseConverter(IntegerConverter.class)
public @interface IsaInt {
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
}
