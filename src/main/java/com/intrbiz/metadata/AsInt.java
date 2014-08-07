package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.IntegerConverter;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseConverter(IntegerConverter.class)
public @interface AsInt
{
    /**
     * The default value to coalesce to if enabled
     */
    int defaultValue() default 0;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
