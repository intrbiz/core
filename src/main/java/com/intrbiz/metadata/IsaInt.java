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
public @interface IsaInt
{   
    /**
     * The minimum valid value
     */
    int min() default Integer.MIN_VALUE;
    
    /**
     * The maximum valid value
     */
    int max() default Integer.MAX_VALUE;
    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
    
    /**
     * The default value to coalesce to if enabled
     */
    int defaultValue() default 0;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
