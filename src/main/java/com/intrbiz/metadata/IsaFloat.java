package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.FloatConverter;
import com.intrbiz.validator.validators.FloatValidator;

/**
 * Check the range of a float value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(FloatValidator.class)
@UseConverter(FloatConverter.class)
public @interface IsaFloat 
{    
    /**
     * The minimum valid value
     */
    float min() default Float.MIN_VALUE;
    
    /**
     * The maximum valid value
     */
    float max() default Float.MAX_VALUE;
    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
    
    /**
     * The default value to coalesce to if enabled
     */
    float defaultValue() default 0;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
