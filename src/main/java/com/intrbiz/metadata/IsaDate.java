package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.DateConverter;
import com.intrbiz.validator.validators.DateValidator;

/**
 * Assert the value is a Date
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(DateValidator.class)
@UseConverter(DateConverter.class)
public @interface IsaDate {
}
