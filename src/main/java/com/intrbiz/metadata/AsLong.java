package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.LongConverter;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseConverter(LongConverter.class)
public @interface AsLong
{
    /**
     * The default value to coalesce to if enabled
     */
    long defaultValue() default 0;
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
