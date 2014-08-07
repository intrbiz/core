package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.BooleanConverter;
import com.intrbiz.validator.validators.BooleanValidator;

/**
 * Check the a boolean value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(BooleanValidator.class)
@UseConverter(BooleanConverter.class)
public @interface IsaBoolean {
    
    /**
     * Is a non-null value required
     */
    boolean mandatory() default false;
    
    /**
     * The default value to coalesce to if enabled
     */
    boolean defaultValue() default false;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
