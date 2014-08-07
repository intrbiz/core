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
public @interface IsaDouble 
{
    /**
     * The minimum valid value
     */
    double min() default Double.MIN_VALUE;
    
    /**
     * The maximum valid value
     */
    double max() default Double.MAX_VALUE;
    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
    
    /**
     * The default value to coalesce to if enabled
     */
    double defaultValue() default 0;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
