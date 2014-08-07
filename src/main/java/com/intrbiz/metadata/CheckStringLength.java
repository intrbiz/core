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
public @interface CheckStringLength
{
    /**
     * The minimum length
     */
    int min() default 0;
    
    /**
     * The maximum length
     */
    int max() default Integer.MAX_VALUE;
    
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
