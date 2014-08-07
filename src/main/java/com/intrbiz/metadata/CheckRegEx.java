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
public @interface CheckRegEx
{
    /**
     * The RegEx pattern to use to validate the input
     */
    String value() default ".*" ;
    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
    
    /**
     * The default value to coalesce to if enabled
     */
    String defaultValue() default "";
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
