package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.StringConverter;
import com.intrbiz.validator.validators.EmailValidator;

/**
 * Check the value matches the format for an email address
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(EmailValidator.class)
@UseConverter(StringConverter.class)
public @interface IsaEmailAddress
{    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
}
