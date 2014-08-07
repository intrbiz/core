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
public @interface IsaLong
{
    /**
     * The minimum valid value
     */
    long min() default Long.MIN_VALUE;
    
    /**
     * The maximum valid value
     */
    long max() default Long.MAX_VALUE;
    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
    
    /**
     * The default value to coalesce to if enabled
     */
    long defaultValue() default 0;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
